package com.grupo2.lucaticket.eventos.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.grupo2.lucaticket.eventos.model.Evento;
import com.grupo2.lucaticket.eventos.model.Recinto;
import com.grupo2.lucaticket.eventos.model.adapter.EventoAdapter;
import com.grupo2.lucaticket.eventos.model.response.EventoDto;
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

	Evento evento;
	EventoDto eventoDto;
	EventoDto eventoNull;
	Recinto recinto;
	List<Evento> eventos;
	List<Evento> eventosVacio;

	private final String NOMBRE_EVENTO = "Evento de prueba";
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
	private final String TIPO = "Tipo del recinto";

	@BeforeEach
	void setUp() {
		evento = new Evento();
		eventoDto = new EventoDto();
		eventoNull = new EventoDto();
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
		evento.setNombre(NOMBRE_EVENTO);
		evento.setDescripcionCorta(DESCRIPCION_CORTA);
		evento.setDescripcionLarga(DESCRIPCION_LARGA);
		evento.setFoto(FOTO);
		evento.setFechaEvento(FECHA);
		evento.setPrecio(PRECIOS);
		evento.setPolitaAcceso(POLITICA);
		evento.setRecinto(recinto);
		evento.setGenero(GENERO);

		// EVENTODTO
		eventoDto.setNombre(NOMBRE_EVENTO_NULL);
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
		eventoNull.setDescripcionEvento(DESCRIPCION_CORTA);
		eventoNull.setFoto(FOTO);
		eventoNull.setFechaEvento(FECHA.toLocalDate());
		eventoNull.setHoraEvento(FECHA.toLocalTime());
		eventoNull.setRangoPreciosEvento(PRECIOS);
		eventoNull.setPolitcaAcceso(POLITICA);
		eventoNull.setRecintoEvento(NOMBRE_RECINTO);
		eventoNull.setCiudadEvento(CIUDAD);
		eventoNull.setDireccionEvento(DIRECCION);
		eventoNull.setAforoEvento(AFORO);
		eventoNull.setGenero(GENERO);

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
		mockMvc.perform(post("/eventos/add").content(objectMapper.writeValueAsString(eventoNull))
				.contentType("application/json")).andExpect(status().isBadRequest());
	}

	@Test
	public void cuandoListaNull_Devuelve404() throws Exception {

		logger.info("Aplicando test que devuelve listado");

		// when
		when(eventosService.findAll()).thenReturn(eventosVacio);

		// then
		mockMvc.perform(get("/eventos/lista").contentType("application/json")).andExpect(status().isNotFound());

	}
	
	@Test
	public void cuandoListaEventos_Devuelve200() throws Exception {

		logger.info("Aplicando test que devuelve listado");

		// when
		when(eventosService.findAll()).thenReturn(eventos);

		// then
		mockMvc.perform(get("/eventos/lista").contentType("application/json")).andExpect(status().isOk());

	}
	
	@Test
	public void cuandoEventoPorNombre_Devuelve200() throws Exception {

		logger.info("Aplicando test que devuelve listado");

		// when
		//when(eventosService.findByNombre(NOMBRE_EVENTO)).thenReturn();

		// then
		mockMvc.perform(get("/eventos/nombre/{nombre}").contentType("application/json")).andExpect(status().isNotFound());

	}

}
