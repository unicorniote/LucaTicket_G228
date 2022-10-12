package com.lucaticket.pasarela.controller.error;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lucaticket.pasarela.controller.exceptions.CvvNotValidException;
import com.lucaticket.pasarela.controller.exceptions.SinFondosException;
import com.lucaticket.pasarela.controller.exceptions.TarjetaNotFoundException;
import com.lucaticket.pasarela.utils.ErrorUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TarjetaNotFoundException.class)
	public ResponseEntity<Object> handleTarjetaNotFoundException(TarjetaNotFoundException exception, HttpStatus status,
			WebRequest request) {
		log.info("Lanzando excepción TarjetaNotFoundException...");
		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, status, request);
		return new ResponseEntity<>(customError, status);

	}

	@ExceptionHandler(SinFondosException.class)
	public ResponseEntity<Object> handleSinFondosException(SinFondosException exception, HttpStatus status,
			WebRequest request) {
		log.info("Lanzando excepción TarjetaNotFoundException...");
		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, status, request);
		return new ResponseEntity<>(customError, status);

	}

	@ExceptionHandler(CvvNotValidException.class)
	public ResponseEntity<Object> handleCvvNotValidException(CvvNotValidException exception, HttpStatus status,
			WebRequest request) {
		log.info("Lanzando excepción TarjetaNotFoundException...");
		CustomErrorJson customError = ErrorUtils.customErrorMapper(exception, request);
		return new ResponseEntity<>(customError, status);

	}

//	@Validated
	@ExceptionHandler(ConstraintViolationException.class)
	public void handleConstraintViolationException(HttpServletResponse response) throws IOException {
		log.info("Lanzando excepción ConstraintViolationException...");
		response.sendError(HttpStatus.ALREADY_REPORTED.value());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.info("Capturando excepción MethodArgumentNotValidException");

		CustomErrorJson customError = ErrorUtils.customErrorMapper(ex, headers, status, request);

		return new ResponseEntity<>(customError, headers, status);

	}

}
