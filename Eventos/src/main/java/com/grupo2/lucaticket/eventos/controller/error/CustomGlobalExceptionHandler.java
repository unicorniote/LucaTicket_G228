package com.grupo2.lucaticket.eventos.controller.error;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.grupo2.lucaticket.eventos.utils.ErrorUtils;

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

	@ExceptionHandler(EventoNotFoundException.class)
	public ResponseEntity<Object> handleCvvNotValidException(EventoNotFoundException exception, HttpStatus status,
			WebRequest request) {
		log.info("Lanzando excepción TarjetaNotFoundException...");
		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, request);
		return new ResponseEntity<>(customError, status);

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleCvvNotValidException(ConstraintViolationException exception, HttpStatus status,
			WebRequest request) {
		log.info("Lanzando excepción TarjetaNotFoundException...");
		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, request);
		return new ResponseEntity<>(customError, status);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("HandleMethodArgumentNotValid()");

		CustomErrorJson customError = ErrorUtils.customErrorMapper(ex, headers, status, request);

		return new ResponseEntity<>(customError, headers, status);
	}

	/**
	 * Descripción del método: Intercepta CustomErrorJson
	 * 
	 * @param
	 * @return CustomError
	 * @author Lamia
	 * @version 1.0
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("------ handleHttpRequestMethodNotSupported()");

		CustomErrorJson customError = ErrorUtils.customErrorMapper(ex, headers, status, request);
		return new ResponseEntity<Object>(customError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

		/**
		 * Descripción del método: Método que señaliza que una petición no existe
		 * 
		 * @param
		 * @return
		 * @author Lamia
		 * @version 1.0
		 */

	}
}
