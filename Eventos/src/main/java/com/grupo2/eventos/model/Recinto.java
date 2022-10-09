package com.grupo2.eventos.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
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
	private String _id;
	
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
