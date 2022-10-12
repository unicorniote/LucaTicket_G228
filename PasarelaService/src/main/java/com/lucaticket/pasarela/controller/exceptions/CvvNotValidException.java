package com.lucaticket.pasarela.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(value = HttpStatus.NON_AUTHORITATIVE_INFORMATION)
public class CvvNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CvvNotValidException() {
		super("El código CVV introducido no es válido.");
		log.info("Creando excepción CvvNotValidException...");
	}

}
