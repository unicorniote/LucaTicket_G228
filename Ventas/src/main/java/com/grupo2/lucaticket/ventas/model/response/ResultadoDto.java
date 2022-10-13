package com.grupo2.lucaticket.ventas.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.LinkedHashMap;

@Data
public class ResultadoDto implements Serializable {

    @Schema(name = "idVenta")
    private int idVenta;

    @Schema(name = "usuario", description = "Identificador del usuario")
    private UsuarioDto usuario;

    @Schema(name = "evento", description = "Identificador del evento")
    private EventoDto evento;

    @Schema(name = "resultado", description = "Resultado del pago")
    private LinkedHashMap<?, ?> resultado;
}
