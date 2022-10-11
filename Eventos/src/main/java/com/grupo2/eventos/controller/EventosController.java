package com.grupo2.eventos.controller;


import com.grupo2.eventos.controller.error.EventoNotFoundException;
import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.model.adapter.EventoAdapterI;
import com.grupo2.eventos.model.response.EventoDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.eventos.service.EventosServiceI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


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
@Tag(name="Evento Controller", description = "Listado de endpoints relacionados con la entidad Evento")
public class EventosController {

	private static final Logger logger = LoggerFactory.getLogger(EventosController.class);


	@Autowired
	private EventosServiceI eventosService;
	
	@Autowired
	private EventoAdapterI eventoAdapter;

	
	/**
	* Descripción del método:
	* Método que añade un evento introducido por el administrador.
	* @param evento evento
	* @return {@ResponseEntity} Se devuelve un objeto evento
	* @author Carlos Jesús Pérez Márquez
	* @version 1.0
	*/
	
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
	@PostMapping("/add")
	public ResponseEntity<?> addEvento(@RequestBody Evento evento){

		logger.info("añadiendo Evento");
		System.out.println(evento);
		evento = this.eventosService.save(evento);
		logger.info("El evento se ha añadido correctamente");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evento.get_id()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	/**
	* Método findById - Busca un evento por su Id.
	* 
	* @return Devuelve un objeto eventoDTO
	* 
	* @author Grupo 2 - Tamara Alvarez
	* 
	* @version 1.0
	*/
	
	@Operation(summary = "Listar los eventos",
			description = "Lista todo los eventos existentes en la BBDD de MongoDB",
			tags={"Evento"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",
			description = "Eventos encontrados",
			content = {
					@Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "400", description = "No existen eventos en la bbdd", content = @Content)})
	@GetMapping ("/listar")
	public List<EventoDto> getEventos() {
		logger.info("----------Buscando eventos");
		List<EventoDto> eventos = eventoAdapter.eventoToDto(eventosService.findAll());
		logger.info("Eventos ->: " + eventos.toString());
		return eventos;
	}
	
	/**
	* Método deleteEvento - Elimina un evento por su Id.
	* 
	* @param String id
	* 
	* @author Grupo 2 - Alonso Gómez
	* 
	* @version 1.0
	*/
	
	@Operation(summary = "Eliminar evento",
			description = "Permite eliminar el evento deseado y existente en la BBDD de MongoDB",
			tags={"Evento"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Evento eliminado correctamente",
					content = {@Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "204", description = "El servidor registra la petición correctamente, pero no se ha encontrado el contenido a borrar", content = @Content),
			@ApiResponse(responseCode = "202", description = "El evento aún no ha sido eliminado", content = @Content)})

	@DeleteMapping("/{id}")
	public void deleteEvento(
			@Parameter(description = "ID del evento a localizar", required=true)
			@PathVariable String id) {
		logger.info("Delete, id ->" + id);
		eventosService.deleteById(id);
	}
	
	
	/**
	* Método findByNombre - Busca un evento por su nombre.
	* 
	* @param nombre
	* @return Devuelve un objeto eventoDTO
	* 
	* @author Grupo 2 - Tamara Alvarez
	*/
	
	@Operation(summary = "Lista un evento por su nombre",
			description = "Lista los eventos existentes en la BBDD de MongoDB según el nombre",
			tags={"Evento"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",
			description = "Eventos encontrados",
			content = {
					@Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "400", description = "No existen eventos en la bbdd", content = @Content)})
	@GetMapping("/{nombre}")
	public EventoDto listaEventosNombre(
			@Parameter(description = "Nombre del evento a localizar", required=true) 
			@PathVariable String nombre) {
		logger.info("----------Buscando eventos por nombre");
		Optional<Evento> evento = eventosService.findByNombre(nombre);
		if (evento.isPresent()) {
			return eventoAdapter.eventoToDto(evento.get());
		}else {
			throw new EventoNotFoundException();
		}
	}

	/**
	* Método listarEventosGenero - Lista los eventos según el género aportado.
	* 
	* @param String genero
	* @return List<EventosDto>
	* 
	* @author Grupo 2 - Carlos Jesús
	* 
	* @version 1.0
	*/

	@Operation(summary = "Listar eventos por género indicado",
			description = "Permite listar los eventos según el género deseado y existentes en la BBDD de MongoDB",
			tags={"Evento"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "La petición listar eventos por género se ha realizado correctamente", 
					content ={@Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "400", description = "No existen eventos en la BBDD", content = @Content)})
	@GetMapping("/{genero}")
	public List<EventoDto> listarEventosGenero(@Parameter(description = "Párametro String Genero que recoge el getmapping", required=true)@PathVariable String genero){
		
		logger.info("Listando eventos por género");
		List<EventoDto> eventosGenero =eventoAdapter.eventoToDto(eventosService.findAllByGenero(genero));
		return eventosGenero;
		
	}
	
	
	/**
	* Método findById - Busca un evento por su Id.
	* 
	* @param id
	* @return Devuelve un objeto eventoDTO
	* 
	* @author Grupo 2 - Tamara Alvarez
	*/
	
	@Operation(summary = "Lista un evento por su ID",
			description = "Lista el evento existente en la BBDD de MongoDB según su ID",
			tags={"Evento"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",
			description = "Evento encontrado",
			content = {
					@Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "404", description = "No existe evento con ese ID", content = @Content)})
	@GetMapping("/detalles/{id}")
	public EventoDto listaDetallesEvento(@Parameter(description = "ID del evento a localizar", required=true)@PathVariable String id) {
		Optional<Evento> evento = eventosService.findById(id);
		if (evento.isPresent()) {
			return eventoAdapter.eventoToDto(evento.get());
		}else {
			throw new EventoNotFoundException();
		}
		
	}
	
	/**
	* Método findAllByCiudad - Busca eventos por su cuidad
	* 
	* @param ciudad
	* @return Devuelve un objeto eventoDTO
	* 
	* @author Grupo 2 - Tamara Alvarez
	*/
	
	@Operation(summary = "Lista un evento por su ID",
			description = "Lista el evento existente en la BBDD de MongoDB según su ID",
			tags={"Evento"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",
			description = "Evento encontrado",
			content = {
					@Content(mediaType = "application/json",
					schema = @Schema(implementation = Evento.class))}),
			@ApiResponse(responseCode = "404", description = "No existen eventos en esa ciudad", content = @Content)})
	@GetMapping("/ciudad/{ciudad}")
	public EventoDto listaEventosCiudad(@Parameter(description = "Ciudad del evento a localizar", required=true)@PathVariable String ciudad) {
		Optional<Evento> evento = eventosService.findAllByCiudad(ciudad);
		if(evento.isPresent()) {
			return eventoAdapter.eventoToDto(evento.get());
		}else {
			throw new EventoNotFoundException();
		}
		
	}
	
	
	

}