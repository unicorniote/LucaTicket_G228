package com.grupo2.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo2.eventos.model.Evento;

/**
* @Project LucaTicket
*
* @Classname EventosRepositoryI
*
* @author Grupo 2 -Carlos Jesús Pérez Márquez
*
* @date 06/10/2022
*
* @since 1.0
*
*/


public interface EventosRepositoryI extends MongoRepository<Evento, Integer> {

	
}
