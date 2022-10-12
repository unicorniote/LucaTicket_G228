package com.lucaticket.pasarela.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TarjetaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TarjetaNotFoundException() {
		super("La tarjeta introducida no existe en nuestra base de datos.");
		log.info("Creando excepción TarjetaNotFoundException...");
	}

}
