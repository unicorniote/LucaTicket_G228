package com.grupo2.eventos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.eventos.repository.EventosRepositoryI;

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
public class EventosController {

	private static final Logger logger = LoggerFactory.getLogger(EventosController.class);
	
	
	@Autowired
	private EventosServiceI eventosService;
	
	// Documentación JAVADOC
	
	/**
	* Descripción del método:
	* Método que añade un evento introducido por el administrador.
	* @param Evento evento
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
	
	@Parameter(description = "ID del evento necesario para localizarlo", required=true)
	
	
	
	
	// Endpoint Añadir Evento
	@PostMapping("/add")
	public ResponseEntity<?> addEvento(@Valid @RequestBody Evento evento){
		
		logger.info("añadiendo Evento");
		Evento evento = this.eventosService.save(evento);
		logger.info("El evento se ha añadido correctamente");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evento.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
