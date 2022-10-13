package com.grupo2.lucaticket.ventas.controller.error;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.grupo2.lucaticket.ventas.utils.ErrorUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Descripción de la clase: Clase CustomGlobalExceptionHandler que intercepta
 * errores
 *
 * @author Lamia
 * @version 07/10/2022
 */

@Slf4j
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Método que devuelve una excepción ConstraintViolationException personalizada.
	 * 
	 * @param exception
	 * @param status
	 * @param request
	 * @return ResponseEntity
	 * @author Álvaro Román
	 * @version 1.0
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleCvvNotValidException(ConstraintViolationException exception, HttpStatus status,
			WebRequest request) {
		log.info("Lanzando excepción TarjetaNotFoundException...");
		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, request);
		return new ResponseEntity<>(customError, status);

	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("Lanzando excepción handleHttpMessageNotReadable...");
		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, request);
		return new ResponseEntity<>(customError, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	/**
	 * Método que devuelve una excepción MethodArgumentNotValidException
	 * personalizada.
	 * 
	 * @param exception
	 * @param status
	 * @param request
	 * @param headers
	 * @return ResponseEntity
	 * @author Lamia
	 * @version 1.0
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("HandleMethodArgumentNotValid()");

		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, headers, status, request);

		return new ResponseEntity<>(customError, headers, status);
	}

	/**
	 * Método que devuelve una excepción HttpRequestMethodNotSupportedException
	 * personalizada.
	 * 
	 * @param exception
	 * @param status
	 * @param request
	 * @param headers
	 * @return ResponseEntity
	 * @author Lamia
	 * @version 1.0
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("------ handleHttpRequestMethodNotSupported()");

		CustomErrorJson customError = ErrorUtils.customErrorMapper(ex, headers, status, request);
		return new ResponseEntity<Object>(customError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

	}

}
