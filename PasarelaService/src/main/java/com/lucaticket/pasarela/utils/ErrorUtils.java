package com.lucaticket.pasarela.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import com.lucaticket.pasarela.controller.error.CustomErrorJson;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase ErrorUtils que contiene métodos para el tratamiento de errores.
 *
 * @author Alvaro
 * @version 1.0: 11/10/2022
 */

@Slf4j
public class ErrorUtils {

	/**
	 * Método CustomErrorJson que mapea un error a un error custom.
	 * 
	 * @param Exception  exception
	 * @param HttpStatus status
	 * @param WebRequest request
	 * @return CustomErrorJson
	 * @author Alvaro
	 * @version 1.0
	 */

	public static <T extends RuntimeException> CustomErrorJson customErrorMapper(RuntimeException exception,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		log.info("Mapeando el error a error custom...");
		CustomErrorJson customError = new CustomErrorJson();
		ArrayList<String> mensajes = new ArrayList<>();

		customError.setFecha(LocalDateTime.now());
		customError.setEstado(status.value());
		customError.setError(status.name());
		mensajes.add(exception.getMessage());
		customError.setMensaje(mensajes);

		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=") + 1);
		customError.setRuta(uri);

		return customError;
	}

	public static <T extends RuntimeException> CustomErrorJson customErrorMapper(RuntimeException exception,
			WebRequest request) {
		// TODO Auto-generated method stub
		log.info("Mapeando el error a error custom...");
		CustomErrorJson customError = new CustomErrorJson();
		ArrayList<String> mensajes = new ArrayList<>();

		customError.setFecha(LocalDateTime.now());
//		customError.setEstado(status.value());
//		customError.setError(status.name());
		mensajes.add(exception.getMessage());
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
	 * @author Alvaro
	 * @version 1.0
	 */
	public static CustomErrorJson customErrorMapper(MethodArgumentNotValidException exception, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		log.info("Mapeando error de validación a error custom...");
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
