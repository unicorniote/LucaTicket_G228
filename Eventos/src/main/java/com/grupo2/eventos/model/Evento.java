package com.grupo2.eventos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project LucaTicket
 * 
 * @Classname Evento
 * 
 * @author Grupo 2 - Tamara Alvarez
 *
 * @date 06/10/2022
 * 
 * @since 1.0
 *
 */

@Data
@NoArgsConstructor
@Schema(name = "Evento", description = "Entidad que representa el model de datos de un evento.")
@Document(collection = "Eventos")
public class Evento{

	@Id
	private String _id;

	@NotNull
	private String nombre;

	@NotNull
	private String descripcionCorta;

	@NotNull
	private String descripcionLarga;

	private String foto;

	@Future(message = "La fecha no puede ser pasada")
	@NotNull(message = "La fecha no debe estar vacía")
	private LocalDateTime fechaEvento;

	@NotEmpty
	@Schema(name = "rangoPrecio", description = "Precio del evento")
	private Map<String, Double> precio;


	private String politaAcceso;

	@NotNull
	@DocumentReference(lazy = true)
	private Recinto recinto;

	@Indexed
	@NotNull
	private String genero;

}
