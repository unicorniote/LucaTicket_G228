package com.grupo2.lucaticket.usuario.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase FechaUtils que contiene métodos para trabajar con fechas.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 11/10/2022
 */
@Slf4j
@Component
public class FechaUtils {

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

		log.info("Formateando fecha...");
		final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		return fecha.format(formatoFecha);

	}

	/**
	 * Método formatearFecha que devuelve una String con formato "dd/MM/yyyy
	 * HH:mm:ss" a partir de una objeto LocalDateTime
	 * 
	 * @param LocalDateTime fehca
	 * @return String
	 * @author Álvaro Román Gómez
	 * @version 1.0
	 */
	public static String formatearFecha(LocalDate fecha) {

		log.info("Formateando fecha...");
		final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("YYYY-MM-dd");

		return fecha.format(formatoFecha);

	}

	/**
	 * Método formatearFecha que devuelve una String con formato "dd/MM/yyyy
	 * HH:mm:ss" a partir de una objeto LocalDateTime
	 * 
	 * @param LocalDateTime fehca
	 * @return String
	 * @author Álvaro Román Gómez
	 * @version 1.0
	 */
	public static String formatearFecha(Date fecha) {

		log.info("Formateando fecha...");
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		return dateFormat.format(fecha);

	}

}
