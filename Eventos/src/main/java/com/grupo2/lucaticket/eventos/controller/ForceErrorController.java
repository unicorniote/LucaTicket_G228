package com.grupo2.lucaticket.eventos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.lucaticket.eventos.controller.error.CiudadEventoNotFoundException;
import com.grupo2.lucaticket.eventos.controller.error.EventoNotFoundException;
import com.grupo2.lucaticket.eventos.controller.error.EventosEmptyDatabaseException;
import com.grupo2.lucaticket.eventos.controller.error.GeneroEventoNotFoundException;
import com.grupo2.lucaticket.eventos.controller.error.NombreEventoNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador con los endpoints que lanzan las excepciones personalizadas.
 *
 * @author Álvaro Román
 * @version 13/10/2022
 */
@RestController
@Slf4j
@Tag(name = "Controlador ForceErroController", description = "Controlador que lanza errores personalizados de Eventos")
public class ForceErrorController {

	/**
	 * Método que devuelve la excepción personalizada EventoNotFoundException
	 * 
	 * @throws EventoNotFoundException
	 * @author Álvaro Román
	 * @version 1.0
	 */
	@Operation(summary = "Lanza una excepción EventoNotFoundException", description = "Permite lanzar una excepción de EventoNotFoundException", tags = {
			"EventoNotFoundException" })
	@ApiResponse(responseCode = "404", description = "El evento no existe ne la base de datos", content = {
			@Content() })
	@GetMapping(value = "/eventos/eventoNotFoundException")
	public void throwEventoNotFoundException() {
		log.info("Lanzando exception EventoNotFoundException...");
		throw new EventoNotFoundException();
	}

	/**
	 * Método que devuelve la excepción personalizada GeneroEventoNotFoundException
	 * 
	 * @throws GeneroEventoNotFoundException
	 * @author Álvaro Román
	 * @version 1.0
	 */
	@Operation(summary = "Lanza una excepción GeneroEventoNotFoundException", description = "Permite lanzar una excepción de GeneroEventoNotFoundException", tags = {
			"GeneroEventoNotFoundException" })
	@ApiResponse(responseCode = "404", description = "No hay eventos de ese género", content = { @Content() })
	@GetMapping(value = "/eventos/generoEventoNotFoundException")
	public void throwGeneroEventoNotFoundException() {
		log.info("Lanzando exception GeneroEventoNotFoundException...");
		throw new GeneroEventoNotFoundException();
	}

	/**
	 * Método que devuelve la excepción personalizada NombreEventoNotFoundException
	 * 
	 * @throws NombreEventoNotFoundException
	 * @author Álvaro Román
	 * @version 1.0
	 */
	@Operation(summary = "Lanza una excepción NombreEventoNotFoundException", description = "Permite lanzar una excepción de NombreEventoNotFoundException", tags = {
			"NombreEventoNotFoundException" })
	@ApiResponse(responseCode = "404", description = "No hay eventos con ese nombre", content = { @Content() })
	@GetMapping(value = "/eventos/nombreEventoNotFoundException")
	public void throwNombreEventoNotFoundException() {
		log.info("Lanzando exception NombreEventoNotFoundException...");
		throw new NombreEventoNotFoundException();
	}

	/**
	 * Método que devuelve la excepción personalizada CiudadEventoNotFoundException
	 * 
	 * @throws CiudadEventoNotFoundException
	 * @author Álvaro Román
	 * @version 1.0
	 */
	@Operation(summary = "Lanza una excepción CiudadEventoNotFoundException", description = "Permite lanzar una excepción de CiudadEventoNotFoundException", tags = {
			"CiudadEventoNotFoundException" })
	@ApiResponse(responseCode = "404", description = "No hay eventos en esa ciudad", content = { @Content() })
	@GetMapping(value = "/eventos/ciudadEventoNotFoundException")
	public void throwCiudadEventoNotFoundException() {
		log.info("Lanzando exception CiudadEventoNotFoundException...");
		throw new CiudadEventoNotFoundException();
	}

	/**
	 * Método que devuelve la excepción personalizada EventosEmptyDatabaseException
	 * 
	 * @throws EventosEmptyDatabaseException
	 * @author Álvaro Román
	 * @version 1.0
	 */
	@Operation(summary = "Lanza una excepción EventosEmptyDatabaseException", description = "Permite lanzar una excepción de EventosEmptyDatabaseException", tags = {
			"CiudadEventoNotFoundException" })
	@ApiResponse(responseCode = "404", description = "No hay eventos en esa ciudad", content = { @Content() })
	@GetMapping(value = "/eventos/eventosEmptyDatabaseException")
	public void throweventosEmptyDatabaseException() {
		log.info("Lanzando exception EventosEmptyDatabaseException...");
		throw new EventosEmptyDatabaseException();
	}

}