package com.grupo2.eventos.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.model.Recinto;
import com.grupo2.eventos.model.adapter.EventoAdapter;
import com.grupo2.eventos.service.EventosServiceI;

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
	Evento eventoNull;
	Recinto recinto;
	List<Evento> eventos = new ArrayList<>();
	List<Evento> eventosVacio = new ArrayList<>();

	private final String ID_EVENTO = "1";
	private final String ID_RECINTO = "1";
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
		eventoNull = new Evento();
		recinto = new Recinto();
		objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

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
		evento.setFechaEvento(FECHACOMPLETA);
		evento.setPrecio(PRECIOS);
		evento.setPolitaAcceso(POLITICA);
		evento.setRecinto(recinto);
		evento.setGenero(GENERO);

		// EVENTONULL
		eventoNull.setNombre(NOMBRE_EVENTO_NULL);
		eventoNull.setDescripcionCorta(DESCRIPCION_CORTA);
		eventoNull.setDescripcionLarga(DESCRIPCION_LARGA);
		eventoNull.setFoto(FOTO);
		eventoNull.setFechaEvento(FECHACOMPLETA);
		eventoNull.setPrecio(PRECIOS);
		eventoNull.setPolitaAcceso(POLITICA);
		eventoNull.setRecinto(recinto);
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

		// When
		when(eventosService.save(evento)).thenReturn(evento);

		mockMvc.perform(post("/eventos/add")
				.content(objectMapper.writeValueAsString(evento))
				.contentType("application/json"))
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
	public void cuandoListemosDevuelveLista() throws Exception {

		logger.info("Aplicando test que devuelve listado");

		// when
		when(eventosService.findAll()).thenReturn(eventos);

		// then
		mockMvc.perform(get("/eventos/listar").contentType("application/json")).andExpect(status().isOk());

	}
	
	@Test
	public void cuandoPideListarEventos_entoncesDevuelve200() throws Exception {
		
		logger.info("Aplicando test que devuelve 200");
		
		when(eventosService.findAll()).thenReturn(eventos);
		
		mockMvc.perform(get("/eventos/listar")
				.contentType("application/json"))
				.andExpect(status().isOk());		
		
	}
	
	
	/**
	 * Terminar de arreglar
	 * 
	@Test
	public void cuandoArrayListVacio_entoncesDevuelve400() throws Exception {
		
		logger.info("Aplicando test que devuelve 400");
		
		List<Evento> eventosVacio = new ArrayList<Evento>();
		
		when(eventosService.findAll()).thenReturn(eventosVacio);
		
		mockMvc.perform(get("/eventos/listar")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}*/

}
