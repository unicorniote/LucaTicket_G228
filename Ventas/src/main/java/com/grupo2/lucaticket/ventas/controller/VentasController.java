package com.grupo2.lucaticket.ventas.controller;

import com.grupo2.lucaticket.ventas.model.Venta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.lucaticket.ventas.service.VentasServiceI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


/**
 * @author Lamia
 * @Project LucaTicket
 * @Classname VentasController
 * @date 11/10/2022
 * @since 1.0
 */

@RestController
@RequestMapping("/ventas")
public class VentasController {

    private static final Logger logger = LoggerFactory.getLogger(VentasController.class);

    @Autowired
    private VentasServiceI ventasService;

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
        //	{
//		"usuario": 3,
//		"evento": "6343bd3cf73ca953a3eda29f"
//	}
        logger.info("Add venta ->: " + venta);
        venta = ventasService.addVenta(venta);
        logger.info("Venta from database ->: " + venta);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    // prueba comit
}
