package com.grupo2.eventos.controller;

import java.net.URI;
import java.util.Collection;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.service.EventosServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
* @Project LucaTicket
*
* @Classname EventosController
*
* @author Grupo 2 -Carlos Jesús Pérez Márquez
*
* @date 06/10/2022
*
* @since 1.0
*
*/


@RestController
@Validated
@RequestMapping("/eventos")
@Tag(name="Student Controller", description = "Listado de endpoints relacionados con la entidad Evento")
public class EventosController{

	private static final Logger log= LoggerFactory.getLogger(EventosController.class);


	@Autowired
	private EventosServiceI eventosService;
	
	@Autowired
	private EventosAdapter eventoAdapter;

	// Documentación JAVADOC

	/**
	* Descripción del método:
	* Método que añade un evento introducido por el administrador.
	* @param evento evento
	* @return {@ResponseEntity} Se devuelve un obejto evento
	* @author Carlos Jesús Pérez Márquez
	* @version 1.0
	*/



	//Documentación OpenApi

	@Operation(summary = "Añadir un evento al archivo JSON",
			description = "Dado un evento, se añade al archivo JSON que conforma la BBDD de MongoDB",
			tags={"Evento"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "201",
			description = "Evento guardado correctamente",
			content = {
					@Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class))}),

			@ApiResponse(responseCode = "400", description = "El evento no se ha añadido", content = @Content)})

	// Duda-¿es necesario aqui? -> @Parameter(description = "ID del evento necesario para localizarlo", required=true)
	// Endpoint Añadir Evento
	@PostMapping("/add")
	public ResponseEntity<?> addEvento(@Valid @RequestBody Evento evento){

		log.info("añadiendo Evento");
		evento = this.eventosService.save(evento);
		log.info("El evento se ha añadido correctamente");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evento.getID()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	/**
	* Método findById - Busca un evento por su Id.
	* 
	* @param ID
	* 
	* @return {@EventoAdapterI} Se devuelve un objeto eventoDTO
	* 
	* @author Grupo 2 - Tamara Alvarez
	* 
	* @version 1.0
	*/
	
	@Operation(summary = "Listar los eventos",
			description = "Lista todo los eventos existentes en la BBDD de MongoDB",
			tags={"Evento"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "201",
			description = "Eventos encontrados",
			content = {
					@Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "400", description = "No existen eventos en la bbdd", content = @Content)})
	@GetMapping
	public Collection<Evento> getEventos() {
		log.info("----------Buscando eventos");
		final Collection<Evento> eventos = eventosService.findAll();
		return eventoAdapter.of(eventos);
	}


	
	


}
