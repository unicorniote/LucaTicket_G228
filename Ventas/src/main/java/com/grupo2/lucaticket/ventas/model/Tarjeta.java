package com.grupo2.lucaticket.ventas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Tarjeta", description = "Entidad de tipo Tajeta")
public class Tarjeta {

	@Schema(name = "Número de tarjeta", description = "Número correspondiente a la tarjeta de pago.")
	@Pattern(regexp = "^[0-9]{9}$", message = "El número de tarjeta debe contener 9 números sin espacios")
	private String numeroTarjeta;
	@Schema(name = "CVV", description = "Código Valor de Verificación de la tarjeta.")
	@Pattern(regexp = "^[0-9]{3}$", message = "El CVV deben ser 3 números sin espacios")
	private String cvv;

}
