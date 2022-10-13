package com.grupo2.lucaticket.ventas.model.response;

import java.io.Serializable;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;



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

	@Schema(name = "id", description = "Identificador de la compra")
	private int id;

	@Schema(name = "usuario", description = "Identificador del usuario")
	private UsuarioDto usuario;

	@Size(max = 30)
	@Schema(name = "evento", description = "Identificador del evento")
	private EventoDto evento;
}
