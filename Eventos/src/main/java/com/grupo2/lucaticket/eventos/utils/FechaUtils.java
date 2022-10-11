package com.grupo2.lucaticket.eventos.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase FechaUtils que contiene métodos para trabajar con fechas.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 07/10/2022
 */
public class FechaUtils {

	private static final Logger logger = LoggerFactory.getLogger(FechaUtils.class);

	/**
	 * Método formatearFecha que devuelve una String con formato "dd/MM/yyyy
	 * HH:mm:ss" a partir de una objeto LocalDateTime
	 * 
	 * @param LocalDateTime fehca
	 * @return String
	 * @author Álvaro Román Gómez
	 * @version 1.0
	 */
	public static String formatearFecha(LocalDateTime fecha) {

		logger.info("Formateando fecha...");
		final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		return fecha.format(formatoFecha);

	}

}
