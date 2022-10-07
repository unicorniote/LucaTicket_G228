package com.grupo2.eventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.repository.EventosRepositoryI;


/**
 * Descripción de la clase:
 * Clase EventosService encargada de  llamar a los métodos
 *
 * @author Lamia
 * @version 06/10/2022
 */

@Service
public class EventosService implements EventosServiceI{
	
	@Autowired
	private EventosRepositoryI repo;
	
	/**
	* Descripción del método:
	* Método que guarda los Eventos
	* @param  
	* @return repositorio eventos
	* @author Lamia
	* @version 1.0
	*/
	
	@Override
	public Evento save (Evento evento) {
		return repo.save(evento);
		
		
	}
}
