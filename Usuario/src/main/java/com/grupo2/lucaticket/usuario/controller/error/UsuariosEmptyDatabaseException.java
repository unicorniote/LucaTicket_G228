package com.grupo2.lucaticket.usuario.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project LucaTicket
 * @Classname UsuariosEmptyDatabaseException
 * @author Álvaro Román
 * @date 13/10/2022
 * @since 1.0
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuariosEmptyDatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que lanza una excepción
	 *
	 * @return Mensaje que avisa que no hay usuarios en la base de datos
	 * @since 1.0
	 */
	public UsuariosEmptyDatabaseException() {
		super("No hay usuarios en la base de datos");
	}

}
