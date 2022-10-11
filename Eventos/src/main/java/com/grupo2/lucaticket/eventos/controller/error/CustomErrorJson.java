package com.grupo2.lucaticket.eventos.controller.error;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo2.lucaticket.eventos.utils.FechaUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase CustomErrorJson que sirve como molde para crear nuestras excepciones
 * personalizadas.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 06/10/2022
 */
@Data
@NoArgsConstructor
public class CustomErrorJson {

	private String fecha;
	private int estado;
	private String error;
	private List<String> mensaje;
	private String ruta;
	private String custom;

	public CustomErrorJson(LocalDateTime fecha, int estado, String error, List<String> mensaje, String ruta) {

		super();
		this.fecha = FechaUtils.formatearFecha(fecha);
		this.estado = estado;
		this.error = error;
		this.mensaje = mensaje;
		this.ruta = ruta;
		this.custom = "Esto es un error personalizado";

	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = FechaUtils.formatearFecha(fecha);
	}

}
