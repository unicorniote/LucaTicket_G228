package com.grupo2.eventos.controller.error;

public class EventoNotFoundExceptionByGenre extends RuntimeException {

	private static final long serialVersionUID =1L;
	
	public EventoNotFoundExceptionByGenre(String genero) {
		
		super("Epic fail: Evento de este " + genero + " no existe");
	}
}
