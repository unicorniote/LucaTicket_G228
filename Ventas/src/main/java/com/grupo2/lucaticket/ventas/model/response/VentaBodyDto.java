package com.grupo2.lucaticket.ventas.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class VentaBodyDto implements Serializable {

    @Schema(name = "usuario", description = "Identificador del usuario")
    private int usuario;

    @Schema(name = "evento", description = "Identificador del evento")
    private String evento;

    @Schema(name = "tarjetaNum", description = "Numero de la tarjeta")
    private String tarjetaNum;

    @Schema(name = "cvv", description = "Codigo de seguridad")
    private String cvv;
}
