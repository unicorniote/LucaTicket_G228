package com.grupo2.lucaticket.eventos.repository;

import java.util.List;

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
	
	List<Evento> findAllByGenero(String genero);
	List<Evento> findAllByNombre(String nombre);
}
