package com.grupo2.lucaticket.usuario.controller.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase CustomGlobalExceptionHandler que intercepta errores
 *
 * @author Álvaro Román
 * @version 13/10/2022
 */
@Slf4j
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	/**
//	 * Método que devuelve una excepción UsuarioNotFoundException personalizada.
//	 * 
//	 * @param exception
//	 * @param status
//	 * @param request
//	 * @return ResponseEntity
//	 * @author Álvaro Román
//	 * @version 1.0
//	 */
//	@ExceptionHandler(UsuarioNotFoundException.class)
//	public ResponseEntity<Object> handleUsuarioNotFoundException(UsuarioNotFoundException exception, HttpStatus status,
//			WebRequest request) {
//		log.info("Lanzando excepción TarjetaNotFoundException...");
//		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, request);
//		return new ResponseEntity<>(customError, status);
//
//	}
//
//	/**
//	 * Método que devuelve una excepción ConstraintViolationException personalizada.
//	 * 
//	 * @param exception
//	 * @param status
//	 * @param request
//	 * @return ResponseEntity
//	 * @author Álvaro Román
//	 * @version 1.0
//	 */
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<Object> handleCvvNotValidException(ConstraintViolationException exception, HttpStatus status,
//			WebRequest request) {
//		log.info("Lanzando excepción TarjetaNotFoundException...");
//		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, request);
//		return new ResponseEntity<>(customError, status);
//
//	}
//
//	/**
//	 * Método que devuelve una excepción MethodArgumentNotValidException
//	 * personalizada.
//	 * 
//	 * @param exception
//	 * @param status
//	 * @param request
//	 * @param headers
//	 * @return ResponseEntity
//	 * @author Lamia
//	 * @version 1.0
//	 */
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		log.info("HandleMethodArgumentNotValid()");
//
//		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, headers, status, request);
//
//		return new ResponseEntity<>(customError, headers, status);
//	}
//
//	/**
//	 * Método que devuelve una excepción HttpRequestMethodNotSupportedException
//	 * personalizada.
//	 * 
//	 * @param exception
//	 * @param status
//	 * @param request
//	 * @param headers
//	 * @return ResponseEntity
//	 * @author Lamia
//	 * @version 1.0
//	 */
//	@Override
//	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		log.info("------ handleHttpRequestMethodNotSupported()");
//
//		CustomErrorJson customError = ErrorUtils.customErrorMapper(ex, headers, status, request);
//		return new ResponseEntity<Object>(customError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
//
//	}

}
