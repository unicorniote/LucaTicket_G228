package com.grupo2.lucaticket.ventas.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 * Clase de tipo DTO que reúne información de un evento.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 06/10/2022
 */
@Data
@Schema(name = "Evento DTO", description = "Objeto de tipo DTO de un Evento")
public class EventoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Schema(name = "Nombre", description = "Nombre del evento")
    private String nombre;
    @Schema(name = "Descripción", description = "Descripción del evento")
    private String descripcionEvento;
    @Schema(name = "Foto", description = "Foto del evento")
    private LocalDate fechaEvento;
}
