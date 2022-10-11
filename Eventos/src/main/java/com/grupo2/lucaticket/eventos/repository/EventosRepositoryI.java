package com.grupo2.lucaticket.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grupo2.lucaticket.eventos.model.Evento;

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
public interface EventosRepositoryI extends MongoRepository<Evento, String> {
}
