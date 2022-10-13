package com.grupo2.lucaticket.ventas.controller;

import com.grupo2.lucaticket.ventas.feignclients.EventoFeignClient;
import com.grupo2.lucaticket.ventas.feignclients.UsuarioFeignClients;
import com.grupo2.lucaticket.ventas.model.Venta;
import com.grupo2.lucaticket.ventas.model.response.EventoResponseDto;
import com.grupo2.lucaticket.ventas.model.response.UsuarioDto;
import com.grupo2.lucaticket.ventas.model.response.VentasDto;
import com.grupo2.lucaticket.ventas.model.response.adapter.EventoAdapterI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.lucaticket.ventas.service.VentasServiceI;


/**
 * @author Lamia
 * @Project LucaTicket
 * @Classname VentasController
 * @date 11/10/2022
 * @since 1.0
 */

@RestController
@RequestMapping("/ventas")
@Tag(name="Ventas Controller", description = "Listado de endpoints relacionados con Ventas")

public class VentasController {

    private static final Logger logger = LoggerFactory.getLogger(VentasController.class);

    @Autowired
    private VentasServiceI ventasService;


    @Autowired
    private UsuarioFeignClients usuarioFeignClients;

    @Autowired
    private EventoFeignClient eventoFeignClient;

    @Autowired
    private EventoAdapterI eventoAdapter;

    /**
     * Endpoint para crear una venta en base al usuario y evento
     *
     * @param venta Objeto serializado donde obtenemos el usuario y el evento
     * @return La ruta del enpoint con el id del objeto generado y guardado en la base de datos
     * @author Grupo 2 - Alonso
     * @version 1.0 : 11/10/2022
     */
    @Operation(summary = "Añadir una venta al sistema mediante un JSON en el body",
            description = "Dado un usuario y un evento se genera una venta",
            tags = {"Usuario", "Evento"})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Venta creada correctamente",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Venta.class))
                    }),
            @ApiResponse(responseCode = "400",
                    description = "La venta no se agregado correctamente",
                    content = @Content)
    })

    @PostMapping("/add")
    public ResponseEntity<?> addVenta(@RequestBody Venta venta) {
        logger.info("Add venta ->: " + venta);
        logger.info("Comprobando usuario " + venta.getUsuario());
        final UsuarioDto usuarioDto = usuarioFeignClients.getUsuario(venta.getUsuario());
        logger.info("usuario encontrado ->: " + usuarioDto);
        final EventoResponseDto eventoDto = eventoFeignClient.getEvento(venta.getEvento());
        logger.info("evento encontrado ->: " + eventoDto);
        if (usuarioDto != null && eventoDto != null) {
            venta = ventasService.addVenta(venta);
        }
        logger.info("Venta from database ->: " + venta);
        VentasDto ventasDto = new VentasDto();
        ventasDto.setId(venta.getId());
        ventasDto.setUsuario(usuarioDto);
        ventasDto.setEvento(eventoAdapter.of(eventoDto));
        return new ResponseEntity<>(ventasDto, HttpStatus.ACCEPTED);
    }
}
