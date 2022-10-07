package com.grupo2.eventos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

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
@AllArgsConstructor
@Schema(name = "Evento", description = "Entidad que representa el model de datos de un evento.")

@Document(collection = "eventos")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String _id;
	
	@NotNull(message = "El nombre no debe estar vacío")
	@Schema(name = "ID", description = "Identificador númerico del evento")
	private int ID;

	@NotNull
	private String nombre;

	@NotNull
	private String descripCorta;

	@NotNull
	private String descripExtendida;

	private boolean foto;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Future(message = "La fecha no puede ser pasada")
	@NotNull(message = "La fecha no debe estar vacía")
	private LocalDate fechaEvento;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime horaEvento;

	@NotEmpty
	@Positive
	@Schema(name = "rangoPrecio", description = "Precio del evento")
	private Map<String, Double> rangoPrecio = new HashMap<>();


	private String politicaAcceso;

	@NotNull
	private Recinto recinto;

	@Indexed
	@NotNull
	private String genero;

}
