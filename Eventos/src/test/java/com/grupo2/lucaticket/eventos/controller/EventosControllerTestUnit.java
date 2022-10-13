package com.grupo2.lucaticket.eventos.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.grupo2.lucaticket.eventos.model.Evento;
import com.grupo2.lucaticket.eventos.model.Recinto;
import com.grupo2.lucaticket.eventos.model.adapter.EventoAdapter;
import com.grupo2.lucaticket.eventos.model.response.EventoDto;
import com.grupo2.lucaticket.eventos.repository.EventosRepositoryI;
import com.grupo2.lucaticket.eventos.service.EventosServiceI;

@WebMvcTest(EventosController.class)
public class EventosControllerTestUnit {

	private static final Logger logger = LoggerFactory.getLogger(EventosControllerTestUnit.class);

	// Given

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private EventoAdapter eventoAdapter;

	@MockBean
	private EventosServiceI eventosService;

	@MockBean
	private EventosRepositoryI eventosRepository;

	Evento evento;
	Evento eventoNull;
	Evento eventoActualizado;
	EventoDto eventoDto;
	EventoDto eventoDtoNull;
	Recinto recinto;
	List<Evento> eventos;
	List<Evento> eventosVacio;

	private final String ID = "6342ffa7db6b886e7104d2fe";
	private final String ID_NULL = "";
	private final String NOMBRE_EVENTO = "TomorrowLand";
	private final String NOMBRE_EVENTO_ACTUALIZADO = "Evento actualizado";
	private final String NOMBRE_EVENTO_NULL = null;
	private final String DESCRIPCION_CORTA = "Descripción corta del evento";
	private final String DESCRIPCION_LARGA = "Descripción larga del evento";
	private final String FOTO = "URL";
	private final LocalDateTime FECHA = LocalDateTime.now();
	private final Map<String, Double> PRECIOS = Map.of("General", 50.0, "VIP", 100.0);
	private final String POLITICA = "No se adminten menores";
	private final String NOMBRE_RECINTO = "Nombre del recinto";
	private final String CIUDAD = "Madrid";
	private final String DIRECCION = "LUCATIC";
	private final int AFORO = 100;
	private final String GENERO = "Genero del evento";
	private final String GENERO_NULL = null;
	private final String TIPO = "Tipo del recinto";

	@BeforeEach
	void setUp() {
		evento = new Evento();
		eventoNull = new Evento();
		eventoActualizado=new Evento();
		eventoDto = new EventoDto();
		eventoDtoNull = new EventoDto();
		recinto = new Recinto();
		objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
		eventos = new ArrayList<>();
		eventosVacio = new ArrayList<>();

		// RECINTO
		recinto.setNombreRecinto(NOMBRE_RECINTO);
		recinto.setCiudad(CIUDAD);
		recinto.setDireccion(DIRECCION);
		recinto.setTipo(TIPO);
		recinto.setAforo(AFORO);

		// EVENTO
		evento.set_id(ID);
		evento.setNombre(NOMBRE_EVENTO);
		evento.setDescripcionCorta(DESCRIPCION_CORTA);
		evento.setDescripcionLarga(DESCRIPCION_LARGA);
		evento.setFoto(FOTO);
		evento.setFechaEvento(FECHA);
		evento.setPrecio(PRECIOS);
		evento.setPolitaAcceso(POLITICA);
		evento.setRecinto(recinto);
		evento.setGenero(GENERO);
		
		// EVENTO ACTUALIZADO
		eventoActualizado.set_id(ID);
		eventoActualizado.setNombre(NOMBRE_EVENTO_ACTUALIZADO);
		eventoActualizado.setDescripcionCorta(DESCRIPCION_CORTA);
		eventoActualizado.setDescripcionLarga(DESCRIPCION_LARGA);
		eventoActualizado.setFoto(FOTO);
		eventoActualizado.setFechaEvento(FECHA);
		eventoActualizado.setPrecio(PRECIOS);
		eventoActualizado.setPolitaAcceso(POLITICA);
		eventoActualizado.setRecinto(recinto);
		eventoActualizado.setGenero(GENERO);

		// EVENTODTO
		eventoDto.setNombre(NOMBRE_EVENTO);
		eventoDto.setDescripcionEvento(DESCRIPCION_CORTA);
		eventoDto.setFoto(FOTO);
		eventoDto.setFechaEvento(FECHA.toLocalDate());
		eventoDto.setHoraEvento(FECHA.toLocalTime());
		eventoDto.setRangoPreciosEvento(PRECIOS);
		eventoDto.setPolitcaAcceso(POLITICA);
		eventoDto.setRecintoEvento(NOMBRE_RECINTO);
		eventoDto.setCiudadEvento(CIUDAD);
		eventoDto.setDireccionEvento(DIRECCION);
		eventoDto.setAforoEvento(AFORO);
		eventoDto.setGenero(GENERO);

		// EVENTONULL
		eventoNull.setNombre(NOMBRE_EVENTO_NULL);
		eventoNull.setDescripcionCorta(DESCRIPCION_CORTA);
		eventoNull.setDescripcionLarga(DESCRIPCION_LARGA);
		eventoNull.setFoto(FOTO);
		eventoNull.setFechaEvento(FECHA);
		eventoNull.setPrecio(PRECIOS);
		eventoNull.setPolitaAcceso(POLITICA);
		eventoNull.setRecinto(recinto);
		eventoNull.setGenero(GENERO_NULL);

		// EVENTONULL2
		eventoDtoNull.setNombre(NOMBRE_EVENTO_NULL);
		eventoDtoNull.setDescripcionEvento(DESCRIPCION_CORTA);
		eventoDtoNull.setFoto(FOTO);
		eventoDtoNull.setFechaEvento(FECHA.toLocalDate());
		eventoDtoNull.setHoraEvento(FECHA.toLocalTime());
		eventoDtoNull.setRangoPreciosEvento(PRECIOS);
		eventoDtoNull.setPolitcaAcceso(POLITICA);
		eventoDtoNull.setRecintoEvento(NOMBRE_RECINTO);
		eventoDtoNull.setCiudadEvento(CIUDAD);
		eventoDtoNull.setDireccionEvento(DIRECCION);
		eventoDtoNull.setAforoEvento(AFORO);
		eventoDtoNull.setGenero(GENERO);

		eventos.add(evento);
		eventos.add(evento);
	}

	// When
	/*
	 * Verifica que el controlador responde a una determinada URL, que el método
	 * POST es correcto y el tipo de contenido de solicitud es correcto
	 */

	@Test
	public void cuandoEntradaValida_entoncesDevuelve201() throws Exception {

		logger.info("Aplicando test que devuelve 201");

		// When
		when(eventosService.save(evento)).thenReturn(evento);

		mockMvc.perform(
				post("/eventos/add").content(objectMapper.writeValueAsString(evento)).contentType("application/json"))
				.andExpect(status().isCreated());
	}

	@Test
	public void cuandoEntradaNull_entoncesDevuelve400() throws Exception {

		logger.info("Aplicando test que devuelve 400");

		// then
		mockMvc.perform(post("/eventos/add").content(objectMapper.writeValueAsString(eventoDtoNull))
				.contentType("application/json")).andExpect(status().isBadRequest());
	}

	@Test
	public void cuandoListaNull_Devuelve404() throws Exception {

		logger.info("Aplicando test que devuelve excepcion lista vacia");

		// when
		when(eventosService.findAll()).thenReturn(eventosVacio);

		// then
		mockMvc.perform(get("/eventos/lista").contentType("application/json")).andExpect(status().isNotFound());

	}

	/**
	 * Descripción del método: Test que da ok cuando se listan los eventos.
	 *
	 * @author Grupo 2- Tamara Álvarez
	 *
	 * @version 1.0
	 */
	@Test
	public void cuandoListaEventos_Devuelve200() throws Exception {

		logger.info("Aplicando test que devuelve listado de todos los eventos");

		// when
		when(eventosService.findAll()).thenReturn(eventos);

		// then
		mockMvc.perform(get("/eventos/lista").contentType("application/json")).andExpect(status().isOk());

	}

	/**
	 * Descripción del método: Test que da ok cuando se busca evento por nombre.
	 *
	 * @author Grupo 2 - Tamara Álvarez
	 *
	 * @version 1.0
	 */
	@Test
	public void cuandoEventoPorNombre_Devuelve200() throws Exception {

		logger.info("Aplicando test que devuelve evento por nombre");

		// when
		when(eventosService.findByNombre(NOMBRE_EVENTO)).thenReturn(eventos);

		// then
		mockMvc.perform(get("/eventos/nombre/" + eventoDto.getNombre()).contentType("application/json"))
				.andExpect(status().isOk());

	}

	/**
	 * Descripción del método: Test que da NotFound cuando se busca evento por
	 * nombre null.
	 *
	 * @author Grupo 2 - Tamara Álvarez
	 *
	 * @version 1.0
	 */
	@Test
	public void cuandoEventoNombreNull_Devuelve404() throws Exception {

		logger.info("Aplicando test que devuelve excepcion nombre no encontrado");

		// when
		when(eventosService.findByNombre(eventoNull.getNombre())).thenReturn(eventos);

		// then
		mockMvc.perform(get("/eventos/nombre/" + eventoNull.getNombre()).contentType("application/json"))
				.andExpect(status().isNotFound());
	}

	/**
	 * Descripción del método: Test que da ok cuando se busca evento por género.
	 *
	 * @author Carlos Jesús
	 *
	 * @version 1.0
	 */
	@Test
	public void cuandoEventoGenero_daOk() throws Exception {

		logger.info("Aplicando test que devuelve listado por género");

		when(eventosService.findAllByGenero(GENERO)).thenReturn(eventos);

		mockMvc.perform(get("/eventos/genero/" + evento.getGenero()).contentType("application/json"))
				.andExpect(status().isOk());

	}

	/**
	 * Descripción del método: Test que da error cuando se busca evento por género
	 * null.
	 *
	 * @author Carlos Jesús
	 *
	 * @version 1.0
	 */
	@Test
	public void cuandoEventoGeneroNull_da404() throws Exception {

		logger.info("Aplicando test que devuelve listado por género");

		when(eventosService.findAllByGenero(GENERO_NULL)).thenReturn(eventos);

		mockMvc.perform(get("/eventos/genero/" + eventoNull.getGenero()).contentType("application/json"))
				.andExpect(status().isNotFound());

	}

	/**
	 * Descripción del método: Test que da Ok cuando se elimina un evento.
	 *
	 * @author Grupo 2 - Tamara Álvarez
	 *
	 * @version 1.0
	 */
	@Test
	public void cuandoBorroEvento_daOk() throws Exception {
		logger.info("Aplicando test que elimina un evento");

		mockMvc.perform(delete("/eventos/" + evento.get_id()).contentType("application/json"))
				.andExpect(status().isOk());
	}

	/**
	 * Descripción del método: Test que da NotFound cuando se elimina un evento con
	 * id null.
	 *
	 * @author Grupo 2 - Tamara Álvarez
	 *
	 * @version 1.0
	 */
	@Test
	public void cuandoBorroEventoIdNull_da404() throws Exception {
		Evento eventoNull2 = new Evento();
		eventoNull2.set_id(ID_NULL);
		eventoNull2.setNombre(NOMBRE_EVENTO_NULL);
		eventoNull2.setDescripcionCorta(DESCRIPCION_CORTA);
		eventoNull2.setDescripcionLarga(DESCRIPCION_LARGA);
		eventoNull2.setFoto(FOTO);
		eventoNull2.setFechaEvento(FECHA);
		eventoNull2.setPrecio(PRECIOS);
		eventoNull2.setPolitaAcceso(POLITICA);
		eventoNull2.setRecinto(recinto);
		eventoNull2.setGenero(GENERO_NULL);

		logger.info("Aplicando test que no elimina un evento por tener Id null");

		mockMvc.perform(delete("/eventos/" + eventoNull2.get_id()).contentType("application/json"))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void actualizarEvento_Success() throws Exception {
		
		logger.info("Aplicando test que actualiza evento ");
		
		when(eventosService.findById(evento.get_id())).thenReturn(Optional.of(evento));
		when(eventosService.save(eventoActualizado)).thenReturn(eventoActualizado);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/editar/"+evento.get_id())
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(eventoActualizado));
		
		mockMvc.perform(mockRequest)
        .andExpect(status().isOk())
        .andExpect(jsonPath("/eventos/editar/6342ffa7db6b886e7104d2fe", is("6342ffa7db6b886e7104d2fe")));
        
	}
	
	
}
