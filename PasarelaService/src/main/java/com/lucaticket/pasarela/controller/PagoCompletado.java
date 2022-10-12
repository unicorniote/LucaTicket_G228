package com.lucaticket.pasarela.controller;

import java.time.LocalDateTime;

import com.lucaticket.pasarela.utils.FechaUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PagoCompletado {

	private String fecha;
	private int estado;
	private String mensaje;

	public PagoCompletado() {

		super();
		log.info("Creando mensaje pagado completado...");
		this.fecha = FechaUtils.formatearFecha(LocalDateTime.now());
		this.estado = 202;
		this.mensaje = "Compra realizada correctamente.";

	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = FechaUtils.formatearFecha(fecha);
		log.info("Establaciendo fecha en error custom...");
	}

}
