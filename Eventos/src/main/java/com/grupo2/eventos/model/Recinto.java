package com.grupo2.eventos.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

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
	
	@MongoId(FieldType.OBJECT_ID)
	@Schema(name = "ID", description = "Identificador númerico del recinto")
	private int ID;
	
	@Schema(name = "nomRecinto", description = "Nombre del recinto")
	private String nomRecinto;
	
	@Schema(name = "ciudad", description = "Ciudad donde se encuentra el recinto")
	private String ciudad;
	
	@Schema(name = "direccion", description = "Dirección del recinto")
	private String direccion;
	
	@Schema(name = "tipo", description = "Tipo de recinto (cubierto, descubierto, etc.")
	private String tipo;
	
	@Schema(name = "aforo", description = "Máximo aforo")
	private int aforo;
	
}
