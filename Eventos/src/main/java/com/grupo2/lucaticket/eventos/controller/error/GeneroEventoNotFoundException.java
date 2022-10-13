package com.grupo2.lucaticket.eventos.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase GeneroEventoNotFoundException
 *
 * @author Grupo 2 - Lamia
 * @version 1.0 : 09/10/2022
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GeneroEventoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GeneroEventoNotFoundException() {

		super("No hay ningún evento de ese género");
	}
}
