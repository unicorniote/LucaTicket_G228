package com.grupo2.lucaticket.eventos.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import com.grupo2.lucaticket.eventos.controller.error.CustomErrorJson;
import com.grupo2.lucaticket.eventos.controller.error.EventoNotFoundException;

/**
 * Clase ErrorUtils que contiene métodos para el tratamiento de errores.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 06/10/2022
 */
public class ErrorUtils {

	private static final Logger logger = LoggerFactory.getLogger(ErrorUtils.class);

	/**
	 * Método CustomErrorJson que mapea un error a un error custom.
	 * 
	 * @param MethodArgumentNotValidException exception
	 * @param HttpHeaders                     headers
	 * @param HttpStatus                      status
	 * @param WebRequest                      request
	 * @return CustomErrorJson
	 * @author Álvaro Román Gómez
	 * @version 1.0
	 */
	public static CustomErrorJson customErrorMapper(MethodArgumentNotValidException exception, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		logger.info("Mapeando error a error custom...");
		CustomErrorJson customError = new CustomErrorJson();

		customError.setFecha(LocalDateTime.now());
		customError.setEstado(status.value());
		customError.setError(status.name());

		List<String> mensajes = new ArrayList<String>();
		for (FieldError error : exception.getBindingResult().getFieldErrors()) {
			mensajes.add(error.getField() + ": " + error.getDefaultMessage());
		}
		customError.setMensaje(mensajes);

		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=") + 1);
		customError.setRuta(uri);

		return customError;
	}

	/**
	 * Método CustomErrorJson que mapea un error a un error custom.
	 * 
	 * @param HttpRequestMethodNotSupportedException exception
	 * @param HttpHeaders                            headers
	 * @param HttpStatus                             status
	 * @param WebRequest                             request
	 * @return CustomErrorJson
	 * @author Álvaro Román Gómez
	 * @version 1.0
	 */
	public static CustomErrorJson customErrorMapper(HttpRequestMethodNotSupportedException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		logger.info("Mapeando error a error custom...");
		CustomErrorJson customError = new CustomErrorJson();

		customError.setFecha(LocalDateTime.now());
		customError.setEstado(status.value());
		customError.setError(status.name());

		StringBuilder builder = new StringBuilder();
		builder.append(exception.getMethod());
		builder.append(" method is not supported for this request. Supported methods are ");
		exception.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

		List<String> mensajes = new ArrayList<String>();
		mensajes.add(builder.toString());

		customError.setMensaje(mensajes);

		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=") + 1);
		customError.setRuta(uri);

		return customError;
	}

	/**
	 * Método CustomErrorJson que mapea un error a un error custom.
	 * 
	 * @param MethodArgumentNotValidException exception
	 * @param HttpHeaders                     headers
	 * @param HttpStatus                      status
	 * @param WebRequest                      request
	 * @return CustomErrorJson
	 * @author Álvaro Román Gómez
	 * @version 1.0
	 */

	public static CustomErrorJson customErrorMapper(EventoNotFoundException exception, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		logger.info("Mapeando error a error custom...");
		CustomErrorJson customError = new CustomErrorJson();

		customError.setFecha(LocalDateTime.now());
		customError.setEstado(status.value());
		customError.setError(status.name());

		List<String> mensajes = new ArrayList<String>();
		for (FieldError error : exception.getBindingResult().getFieldErrors()) {
			mensajes.add(error.getField() + ": " + error.getDefaultMessage());
		}
		customError.setMensaje(mensajes);

		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=") + 1);
		customError.setRuta(uri);

		return customError;
	}

}
