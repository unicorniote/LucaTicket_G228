package com.grupo2.eventos.service;

import org.springframework.stereotype.Service;

@Service

/**
 * Descripción de la clase:
 * Clase EventosService encargada de  llamar a los métodos
 *
 * @author Lamia
 * @version 06/10/2022
 */
public class EventosService implements EventosServiceI{
	@Override

	public Evento save (Evento evento) {
		return repo.save(evento);
		
		/**
		* Descripción del método:
		* Método que guarda los Eventos
		* @param  
		* @return repositorio eventos
		* @author Lamia
		* @version 1.0
		*/
	}
}
