package com.grupo2.lucaticket.ventas.controller.error;

import java.time.LocalDateTime;
import java.util.List;

import com.grupo2.lucaticket.ventas.utils.FechaUtils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase CustomErrorJson que sirve como molde para crear nuestras excepciones
 * personalizadas.
 *
 * @author Álvaro Román
 * @version 1.0: 11/10/2022
 */
@Data
@NoArgsConstructor
@Slf4j
public class CustomErrorJson {

	private String fecha;
	private int estado;
	private String error;
	private List<String> mensaje;
	private String ruta;
	private String custom;

	public CustomErrorJson(LocalDateTime fecha, int estado, String error, List<String> mensaje, String ruta) {

		super();
		log.info("Creando error custom...");
		this.fecha = FechaUtils.formatearFecha(fecha);
		this.estado = estado;
		this.error = error;
		this.mensaje = mensaje;
		this.ruta = ruta;
		this.custom = "Esto es un error personalizado";

	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = FechaUtils.formatearFecha(fecha);
		log.info("Establaciendo fecha en error custom...");
	}
}
