package com.grupo2.lucaticket.eventos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

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
	
	@Query("{ 'genero' : ?0 }")
	List<Evento> findAllByGenero(String genero);
	
	@Query("{ $text: { $search: \"?0\" } }")
	Optional<Evento> findByNombre(String nombre);
	
	@Query("{ 'recinto.ciudad' : ?0 }")
	Optional<Evento> findAllByCiudad(String ciudad);
}
