package com.grupo2.eventos.controller.error;





public class EventoNotFoundException  extends RuntimeException{
	
	
	private static final long serialVersionUID =1L;
	public EventoNotFoundException() {
		super ("Epic fail: Este evento no existe");
		
	}
	
	public EventoNotFoundException(Long id) {
		super ("Epic Fail: No existe el evento"+id);
	}

}
