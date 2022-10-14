package com.grupo2.lucaticket.eventos.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase GeneroEventoNotFoundException
 *
 * @author Grupo 2 - Alvaro
 * @version 1.0 : 13/10/2022
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NombreEventoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NombreEventoNotFoundException() {

		super("No hay ningún evento con ese nombre");
	}
}
