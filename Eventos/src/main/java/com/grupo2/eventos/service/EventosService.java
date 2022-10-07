package com.grupo2.eventos.service;

import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.repository.EventosRepositoryI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.repository.EventosRepositoryI;


/**
 * @Project LucaTicket
 * 
 * @Classname EventosService
 * 
 * @author Grupo 2 - Lamia
 *
 * @date 06/10/2022
 * 
 * @since 1.0
 *
 */

@Service
public class EventosService implements EventosServiceI{
	
	@Autowired
	private EventosRepositoryI repo;
	
	/**
	* Descripción del método:
	* Método que guarda los Eventos
	* 
	* @param  evento
	* 
	* @return repositorio eventos
	* 
	* @author Lamia
	* 
	* @version 1.0
	*/
	
	@Override
	public Evento save (Evento evento) {
		return repo.save(evento);
		
		
	}

	
	/**
	* Método findAll():
	* Lista todos los eventos existentes
	* 
	* @return repo.finAll()
	* 
	* @author Grupo 2 - Tamara Alvarez
	* 
	* @version 1.0
	*/
	
	@Override
	public Collection<Evento> findAll() {
		return repo.findAll();
	}
	
	
	
}
