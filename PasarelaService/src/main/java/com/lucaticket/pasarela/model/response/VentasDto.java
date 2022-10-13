package com.lucaticket.pasarela.model.response;

import com.lucaticket.pasarela.model.Tarjeta;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Project LucaTicket
 *
 * @Classname VentasDto que contiene la información de una venta relacionando el  ID de un usuario con el de un evento
 *
 * @author Lamia
 *
 * @date 11/10/2022
 *
 * @since 1.0
 *
 */
@Data
@Schema(name = "VentasDto", description = "DTO de Ventas")
public class VentasDto implements Serializable {

    @Schema(name = "usuario", description = "Identificador del usuario")
    private UsuarioDto usuario;

    @Schema(name = "evento", description = "Identificador del evento")
    private EventoDto evento;

    @Schema(name = "tarjeta", description = "Datos financieros para hacer el pago")
    private Tarjeta tarjeta;
}
