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
@AllArgsConstructor
@Document(collection = "recintos")
public class Recinto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String _id;
	
	@NotNull
	@Schema(name = "ID", description = "Identificador númerico del recinto")
	private int ID;
	
	@NotNull
	@NotEmpty
	private String nomRecinto;
	
	@NotNull
	@NotEmpty
	private String ciudad;
	
	@NotNull
	@NotEmpty
	private String direccion;
	
	private String tipo;
	
	@NotNull(message = "El aforo no puede estar vacío")
	@Positive(message = "El aforo debe ser positivo")
	@NotEmpty
	private int aforo;
	
}
