package com.grupo2.lucaticket.eventos.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project LucaTicket
 * 
 * @Classname Recinto
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
@Document(collection = "Recintos")
public class Recinto {

	@Id
	private String _idRecinto;

	@NotNull
	@NotEmpty
	private String nombreRecinto;

	@NotNull
	@NotEmpty
	private String ciudad;

	private String direccion;

	private String tipo;

	@NotNull(message = "El aforo no puede estar vacío")
	@Positive(message = "El aforo debe ser positivo")
	@NotEmpty
	private Integer aforo;

}
