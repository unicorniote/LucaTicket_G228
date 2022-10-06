package com.grupo2.eventos.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project LucaTicket
 * 
 * @Classname Evento
 * 
 * @author Grupo 2 -Tamara
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
public class Evento {

	@Id
	@Schema(name = "ID", description = "Identificador númerico del evento")
	private int ID;

	@Schema(name = "nombre", description = "Nombre del evento")
	private String nombre;

	@Schema(name = "descripCorta", description = "Descripción corta del evento")
	private String descripCorta;

	@Schema(name = "descripExtendida", description = "Descriptción extendida del evento")
	private String descripExtendida;

	@Schema(name = "foto", description = "Atributo que indica si el evento dispone de fotografía")
	private boolean foto;

	@Schema(name = "fechaEvento", description = "Fecha de la celebración del evento")
	private LocalDate fechaEvento;

	@Schema(name = "horaEvento", description = "Hora de comienzo del evento")
	private LocalTime horaEvento;

	@Schema(name = "rangoPrecio", description = "Precio del evento")
	private float rangoPrecio;

	@Schema(name = "politicaAcceso", description = "Descripcion de la política de acceso al evento")
	private String politicaAcceso;

	@Schema(name = "recinto", description = "Datos del recinto donde se celebra el evento")
	private Recinto recinto;

	@Schema(name = "genero", description = "Género musical del evento")
	private String genero;

}
