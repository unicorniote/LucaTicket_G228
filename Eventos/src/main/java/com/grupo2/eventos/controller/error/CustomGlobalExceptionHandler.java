package com.grupo2.eventos.controller.error;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Descripción de la clase:
 * Clase CustomGlobalExceptionHandler que intercepta  errores
 *
 * @author Lamia
 * @version 07/10/2022
 */

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EventoNotFoundException.class)
	public void springHandleNotFound(HttpServletResponse response) throws IOException{
		logger.info("EventoNotFoundException()");;
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
		
		@ExceptionHandler(ConstraintViolationException.class)
		public void constraintViolationException(HttpServletResponse response) throws IOException {
			logger.info("------ ConstraintViolationException() ");
			response.sendError(HttpStatus.BAD_REQUEST.value());
		}
		
	@Override
	protected ResponseEntity<Object>handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request){
		logger.info("HandleMethodArgumentNotValid()");
		
		CustomErrorJson customError = new CustomErrorJson();
		
		List<String> messages = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			messages.add(error.getField() + ": " + error.getDefaultMessage());
		}
		customError.setMessage(messages);
		
		
		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=")+1);
		customError.setPath(uri);

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
		logger.info("------ handleHttpRequestMethodNotSupported()");
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getMethod());
		builder.append(" method is not supported for this request. Supported methods are ");
		ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));
		
		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
		
		/**
		* Descripción del método:
		* Método que señaliza que una petición no existe
		* @param  
		* @return 
		* @author Lamia
		* @version 1.0
		*/

}}

