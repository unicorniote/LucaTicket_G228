package com.grupo2.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo2.eventos.model.Evento;
import org.springframework.stereotype.Repository;

/**
* @Project LucaTicket
*
* @Classname EventosRepository
*
* @author Grupo 2 -Carlos Jesús Pérez Márquez
*
* @date 06/10/2022
*
* @since 1.0
*
*/

@Repository
public interface EventosRepositoryI extends MongoRepository<Evento, String> {

	
}
