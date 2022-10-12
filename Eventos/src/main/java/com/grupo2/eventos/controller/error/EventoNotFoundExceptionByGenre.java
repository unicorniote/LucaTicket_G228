package com.grupo2.eventos.controller.error;



/**
 * Clase EventoNotFoundException
 *
 * @author Grupo 2 - Lamia
 * @version 1.0 : 09/10/2022
 */
public class EventoNotFoundExceptionByGenre extends RuntimeException {

	private static final long serialVersionUID =1L;
	
	public EventoNotFoundExceptionByGenre(String genero) {
		
		super("Epic fail: Evento de este " + genero + " no existe");
	}
}
