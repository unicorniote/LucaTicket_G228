package com.grupo2.lucaticket.eventos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo2.lucaticket.eventos.controller.error.CiudadEventoNotFoundException;
import com.grupo2.lucaticket.eventos.controller.error.EventoNotFoundException;
import com.grupo2.lucaticket.eventos.controller.error.EventosEmptyDatabaseException;
import com.grupo2.lucaticket.eventos.controller.error.GeneroEventoNotFoundException;
import com.grupo2.lucaticket.eventos.model.Evento;
import com.grupo2.lucaticket.eventos.model.adapter.EventoAdapterI;
import com.grupo2.lucaticket.eventos.model.response.EventoDto;
import com.grupo2.lucaticket.eventos.service.EventosServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@Tag(name = "Evento Controller", description = "Listado de endpoints relacionados con la entidad Evento")
public class EventosController {

	private static final Logger logger = LoggerFactory.getLogger(EventosController.class);

	@Autowired
	private EventosServiceI eventosService;

	@Autowired
	private EventoAdapterI eventoAdapter;

	/**
	 * Descripción del método: Método que añade un evento introducido por el
	 * administrador.
	 * 
	 * @param evento
	 * 
	 * @return {@ResponseEntity} Se devuelve un objeto evento
	 * 
	 * @author Carlos Jesús Pérez Márquez
	 * 
	 * @version 1.0
	 */

	@Operation(summary = "Añadir un evento al archivo JSON", description = "Dado un evento, se añade al archivo JSON que conforma la BBDD de MongoDB", tags = {
			"Evento" })

	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Evento guardado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),

			@ApiResponse(responseCode = "400", description = "El evento no se ha añadido", content = @Content) })
	@PostMapping("/add")
	public ResponseEntity<?> addEvento(@Valid @RequestBody Evento evento) {

		logger.info("añadiendo Evento: " + evento);
		evento = this.eventosService.save(evento);
		logger.info("El evento se ha añadido correctamente");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evento.get_id())
				.toUri();

		return ResponseEntity.created(location).body(eventoAdapter.eventoToDto(evento));
	}

	/**
	 * Método findAll - Lista todos los eventos.
	 * 
	 * @return Lista objetos EventoDto
	 * 
	 * @author Grupo 2 - Tamara Alvarez
	 */

	@Operation(summary = "Lista todos los eventos", description = "Lista los eventos existentes en la BBDD de MongoDB", tags = {
			"Evento" })

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos encontrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No existen eventos en la bbdd", content = @Content) })
	@GetMapping("/lista")
	public List<EventoDto> listaEventos() {
		logger.info("----------Buscando eventos ");
		List<Evento> eventos = eventosService.findAll();
		if (eventos.isEmpty()) {
			throw new EventosEmptyDatabaseException();
		} else {
			return eventoAdapter.eventoToDto(eventos);

		}
	}

	/**
	 * Método findByNombre - Busca un evento por su nombre.
	 * 
	 * @param nombre
	 * 
	 * @return Devuelve un objeto eventoDTO
	 * 
	 * @author Grupo 2 - Tamara Alvarez
	 */

	@Operation(summary = "Lista un evento por su nombre", description = "Lista los eventos existentes en la BBDD de MongoDB según el nombre", tags = {
			"Evento" })

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos encontrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No existen eventos en la bbdd", content = @Content) })
	@GetMapping("/nombre/{nombre}")
	public List<EventoDto> listaEventosNombre(
			@Parameter(description = "Nombre del evento a localizar", required = true) @PathVariable String nombre) {
		logger.info("----------Buscando eventos por nombre");
		List<Evento> evento = eventosService.findByNombre(nombre);
		if (evento.isEmpty()) {
			throw new EventoNotFoundException();
		} else {
			return eventoAdapter.eventoToDto(evento);
		}
	}

	/**
	 * Método listarEventosGenero - Lista los eventos según el género aportado.
	 * 
	 * @param genero
	 * 
	 * @return eventosGenero
	 * 
	 * @author Grupo 2 - Carlos Jesús
	 * 
	 * @version 1.0
	 */

	@Operation(summary = "Listar eventos por género indicado", description = "Permite listar los eventos según el género deseado y existentes en la BBDD de MongoDB", tags = {
			"Evento" })

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "La petición listar eventos por género se ha realizado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No existen eventos en la BBDD", content = @Content) })
	@GetMapping("/genero/{genero}")
	public List<EventoDto> listarEventosGenero(
			@Parameter(description = "Párametro String Genero que recoge el getmapping", required = true) @PathVariable String genero) {
		logger.info("----------Buscando eventos por genero");
		List<Evento> evento = eventosService.findAllByGenero(genero);
		if (evento.isEmpty()) {
			throw new GeneroEventoNotFoundException();
		} else {
			return eventoAdapter.eventoToDto(evento);
		}

	}

	/**
	 * Método listaDetallesEvento - Muestra los detalles de un evento buscado por su
	 * ID.
	 * 
	 * @param id
	 * 
	 * @return Devuelve un objeto eventoDTO
	 * 
	 * @author Grupo 2 - Tamara Alvarez
	 */

	@Operation(summary = "Lista un evento por su ID", description = "Lista el evento existente en la BBDD de MongoDB según su ID", tags = {
			"Evento" })

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento encontrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "404", description = "No existe evento con ese ID", content = @Content) })
	@GetMapping("/detalles/{id}")
	public EventoDto eventosById(
			@Parameter(description = "ID del evento a localizar", required = true) @PathVariable String id) {
		Optional<Evento> evento = eventosService.findById(id);
		if (evento.isEmpty()) {
			throw new EventoNotFoundException();
		} else {
			return eventoAdapter.eventoToDto(evento.get());

		}

	}

	/**
	 * Método listaEventosCiudad - Busca eventos por ciudad
	 * 
	 * @param ciudad
	 * 
	 * @return Devuelve un objeto eventoDTO
	 * 
	 * @author Grupo 2 - Tamara Alvarez
	 */

	@Operation(summary = "Lista eventos por ciudad", description = "Lista eventos existentes en la BBDD de MongoDB según su ciudad", tags = {
			"Evento" })

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos encontrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "404", description = "No existen eventos en esa ciudad", content = @Content) })
	@GetMapping("/ciudad/{ciudad}")
	public List<EventoDto> listaEventosCiudad(
			@Parameter(description = "Ciudad del evento a localizar", required = true) @PathVariable String ciudad) {
		List<Evento> evento = eventosService.findByCiudad(ciudad);
		if (evento.isEmpty()) {
			throw new CiudadEventoNotFoundException();
		} else {
			return eventoAdapter.eventoToDto(evento);
		}

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

	@Operation(summary = "Eliminar evento", description = "Permite eliminar el evento deseado y existente en la BBDD de MongoDB", tags = {
			"Evento" })

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento eliminado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "204", description = "El servidor registra la petición correctamente, pero no se ha encontrado el contenido a borrar", content = @Content),
			@ApiResponse(responseCode = "202", description = "El evento aún no ha sido eliminado", content = @Content) })

	@DeleteMapping("/{id}")
	public ResponseEntity<EventoDto> deleteEvento(@PathVariable String id) {
		logger.info("Buscando evento " + id + " en la base de datos...");
		Optional<Evento> eventoOpcional = eventosService.findById(id);
		if (eventoOpcional.isEmpty()) {
			throw new EventoNotFoundException();
		} else {
			logger.info("Eliminando evento " + id + " de la base de datos...");
			Evento evento = eventoOpcional.get();
			eventosService.deleteById(evento.get_id());
			return new ResponseEntity<EventoDto>(eventoAdapter.eventoToDto(evento), HttpStatus.ACCEPTED);
		}
	}

	/**
	 * Método update para modificar Evento
	 * 
	 * @return devuelve un objeto evento
	 * 
	 * @author Grupo 2 - Lamia
	 * 
	 * @version 1.0
	 */

	@Operation(summary = "Busca un evento por id ", description = "Permite modificar el evento seleccionado", tags = {
			"Evento" })

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "La petición listar eventos por género se ha realizado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No existen eventos en la BBDD", content = @Content) })

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(
			@Parameter(description = "Párametro Evento que actualiza el evento", required = true) @PathVariable("id") String id,
			@Valid @RequestBody Evento eventoActualizar) {
		logger.info(" ---- updateEvento (PUT)");
		Optional<Evento> eventoOptcional = eventosService.findById(id);
		if (!eventoOptcional.isPresent()) {
			throw new EventoNotFoundException();
		} else {
			Evento evento = eventoOptcional.get();
			evento.set_id(id);
			evento.setNombre(eventoActualizar.getNombre());
			evento.setDescripcionCorta(eventoActualizar.getDescripcionCorta());
			evento.setDescripcionLarga(eventoActualizar.getDescripcionLarga());
			evento.setFoto(eventoActualizar.getFoto());
			evento.setFechaEvento(eventoActualizar.getFechaEvento());
			evento.setPrecio(eventoActualizar.getPrecio());
			evento.setPolitaAcceso(eventoActualizar.getPolitaAcceso());
			evento.setRecinto(eventoActualizar.getRecinto());
			evento.setGenero(eventoActualizar.getGenero());
			eventosService.save(evento);

			return new ResponseEntity<>(eventoAdapter.eventoToDto(evento), HttpStatus.ACCEPTED);
		}
	}

}