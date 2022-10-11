package com.grupo2.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.grupo2.eventos.model.Evento;

/**
* @Project LucaTicket
*
* @Classname EventosRepository
*
* @author Grupo 2 -Carlos Jesús Pérez Márquez y Lamia
*
* @date 06/10/2022
*
* @since 1.0
*
*/


public interface EventosRepositoryI extends MongoRepository<Evento, Integer> {
	
	@Query(value="{'_id' : $0}", delete = true)
	public void deleteById (String id);

}
