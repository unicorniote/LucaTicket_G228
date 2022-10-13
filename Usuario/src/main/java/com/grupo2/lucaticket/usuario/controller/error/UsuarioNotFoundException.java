package com.grupo2.lucaticket.usuario.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project LucaTicket
 *
 * @Classname UsuarioNotFoundException
 *
 * @author Lamia
 * @date 07/10/2022
 *
 * @since 1.0
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que lanza una excepción
	 *
	 * @param usuario
	 * @return Mensaje que avisa que el usuario buscado no existe
	 * @since 1.0
	 */
	public UsuarioNotFoundException() {
		super("Fail: Este usuario no existe");
	}

	public UsuarioNotFoundException(int id) {
		super("Fail: No existe el usuario");
	}

}
