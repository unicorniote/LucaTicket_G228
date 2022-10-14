package com.lucaticket.pasarela.model.response;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Clase de tipo DTO que reúne información de un evento.
 *
 * @author Alvaro
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
