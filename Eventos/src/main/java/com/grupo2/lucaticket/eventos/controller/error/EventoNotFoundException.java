package com.grupo2.lucaticket.eventos.controller.error;


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


public class EventoNotFoundException  extends RuntimeException{
	
	/**
	 * Metodo que lanza una excepción
	 *
	 * @param evento
	 * @return Mensaje que avisa que el evento buscado no existe
	 * @since 1.0
	 */
	private static final long serialVersionUID =1L;
	public EventoNotFoundException() {
		super ("Epic fail: Este evento no existe");
		
	}
	
	public EventoNotFoundException(Long id) {
		super ("Epic Fail: No existe el evento"+id);
	}
	
	

}
