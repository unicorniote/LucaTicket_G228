package com.lucaticket.pasarela.controller;

import javax.validation.Valid;

import com.lucaticket.pasarela.model.response.InfoCompraDto;
import com.lucaticket.pasarela.model.response.VentasDto;
import com.lucaticket.pasarela.model.response.adapter.InfoAdapterI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaticket.pasarela.controller.exceptions.CvvNotValidException;
import com.lucaticket.pasarela.controller.exceptions.SinFondosException;
import com.lucaticket.pasarela.controller.exceptions.TarjetaNotFoundException;
import com.lucaticket.pasarela.model.Tarjeta;
import com.lucaticket.pasarela.service.ValidarPagosService;
import com.lucaticket.pasarela.utils.ValidationUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
@RequestMapping("/pasarela")
@Tag(name = "Pasarela API", description = "Rest API para la validación de pagos con tarjeta")
public class ValidarPagosController {

    @Autowired
    ValidarPagosService validarService;

    @Autowired
    InfoAdapterI infoAdapterI;

    @Operation(summary = "Validar pago con tarjeta", description = "Dado un número de tarjeta y un código CVV se valida el pago", tags = {"student"})
    @ApiResponses(value = {@ApiResponse(responseCode = "203", description = "El CVV de la tarjeta no es válido", content = {@Content}), @ApiResponse(responseCode = "207", description = "La tarjeta no tiene fondos", content = @Content), @ApiResponse(responseCode = "404", description = "La tarjeta no existe en la base de datos", content = @Content)})
    @PostMapping("/pagar")
    public ResponseEntity<?> pagar(@Valid @RequestBody Tarjeta tarjeta) {
        log.info("Validando pago...");
        if (!ValidationUtils.validarTarjeta(validarService.encontrarTarjeta())) {
            log.info("Número de tarjeta incorrecto");
            throw new TarjetaNotFoundException();
        } else if (!ValidationUtils.validarCvv(validarService.validarCvv())) {
            log.info("CVV incorrecto");
            throw new CvvNotValidException();
        } else if (!ValidationUtils.validarFondos(validarService.consultarFondos())) {
            log.info("Sin fondos");
            throw new SinFondosException();
        } else {
            log.info("Pago completado");
            return new ResponseEntity<>(new PagoCompletado(), HttpStatus.ACCEPTED);
        }

    }

    @Operation(summary = "Mostrar info de la compra", description = "Dado una operacion de venta mostrar la informacion necesaria para el cobro", tags = {"venta"})
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "Mostrando informacion correctamente", content = {@Content})})
    @PostMapping("/info")
    public ResponseEntity<?> addInfo(@RequestBody VentasDto ventasDto) {
        return new ResponseEntity<>(infoAdapterI.of(ventasDto), HttpStatus.ACCEPTED);
    }
}
