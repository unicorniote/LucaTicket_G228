package com.grupo2.lucaticket.eventos.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project LucaTicket
 *
 * @Classname EventoNotFoundException
 *
 * @author Lamia
 * @date 07/10/2022
 *
 * @since 1.0
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventoNotFoundException extends RuntimeException {

	/**
	 * Metodo que lanza una excepción
	 *
	 * @param evento
	 * @return Mensaje que avisa que el evento buscado no existe
	 * @since 1.0
	 */
	private static final long serialVersionUID = 1L;

	public EventoNotFoundException() {
		super("Este evento no existe en la base de datos.");

	}

	public EventoNotFoundException(Long id) {
		super("Este evento no existe en la base de datos: " + id);
	}

}
