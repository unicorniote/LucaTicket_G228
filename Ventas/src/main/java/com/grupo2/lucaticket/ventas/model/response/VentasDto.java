	package com.grupo2.lucaticket.ventas.model.response;
	
	import java.io.Serializable;
	
	import javax.validation.constraints.Size;
	
	import io.swagger.v3.oas.annotations.media.Schema;
	import lombok.Data;
	
		
		@Data
		@Schema(name = "VentasDto", description = "DETO de Ventas")
		public class VentasDto implements Serializable{
			
			 @Schema(name = "usuario", description = "Identificador del usuario")
			    private int usuario;
		
			    @Size(max = 30)
			    @Schema(name = "evento", description = "Identificador del evento")
			    private String evento;
		}
