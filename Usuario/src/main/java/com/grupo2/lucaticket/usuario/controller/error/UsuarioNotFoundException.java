package com.grupo2.lucaticket.usuario.controller.error;

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

public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID =1L;
	
	public UsuarioNotFoundException() {
		super ("Fail: Este usuario no existe");
	}
	
	public UsuarioNotFoundException(int id) {
		super ("Fail: No existe el usuario");
	}
}
