package com.grupo2.lucaticket.eventos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grupo2.lucaticket.eventos.model.Recinto;

/**
 * @Project LucaTicket
 *
 * @Classname RecintosRespository
 *
 * @author Grupo 2 - Álvaro Román
 *
 * @date 13/10/2022
 *
 * @since 1.0
 *
 */
@Repository
public interface RecintosRespositoryI extends MongoRepository<Recinto, String>{


	
}
