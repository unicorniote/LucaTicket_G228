package com.grupo2.eventos.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.model.Recinto;
import com.grupo2.eventos.model.adapter.EventoAdapter;
import com.grupo2.eventos.service.EventosServiceI;



@WebMvcTest(EventosController.class)
public class EventosControllerTestUnit {

	private static final Logger logger = LoggerFactory.getLogger(EventosControllerTestUnit.class);
	//Given 
	
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

	private final int ID_EVENTO = 1;
	private final int ID_RECINTO = 1;
	private final String NOMBRE_EVENTO = "Evento de prueba";
	private final String NOMBRE_EVENTO_NULL=null;
	private final String DESCRIPCION_CORTA = "Descripción corta del evento";
	private final String DESCRIPCION_LARGA = "Descripción larga del evento";
	private final boolean FOTO = true;
	private final LocalDate FECHA = LocalDate.parse("2022-10-06");
	private final LocalTime HORA = LocalTime.parse("22:01:50");
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

		// RECINTO
		recinto.setID(ID_RECINTO);
		recinto.setNomRecinto(NOMBRE_RECINTO);
		recinto.setCiudad(CIUDAD);
		recinto.setDireccion(DIRECCION);
		recinto.setTipo(TIPO);
		recinto.setAforo(AFORO);

		// EVENTO
		evento.setID(ID_EVENTO);
		evento.setNombre(NOMBRE_EVENTO);
		evento.setDescripCorta(DESCRIPCION_CORTA);
		evento.setDescripExtendida(DESCRIPCION_LARGA);
		evento.setFoto(FOTO);
		evento.setFechaEvento(FECHA);
		evento.setHoraEvento(HORA);
		evento.setRangoPrecio(PRECIOS);
		evento.setPoliticaAcceso(POLITICA);
		evento.setRecinto(recinto);
		evento.setGenero(GENERO);
		
		//EVENTONULL
		evento.setID(ID_EVENTO);
		evento.setNombre(NOMBRE_EVENTO_NULL);
		evento.setDescripCorta(DESCRIPCION_CORTA);
		evento.setDescripExtendida(DESCRIPCION_LARGA);
		evento.setFoto(FOTO);
		evento.setFechaEvento(FECHA);
		evento.setHoraEvento(HORA);
		evento.setRangoPrecio(PRECIOS);
		evento.setPoliticaAcceso(POLITICA);
		evento.setRecinto(recinto);
		evento.setGenero(GENERO);
	}
		
		
	//When
	/*Verifica que el controlador responde a una determinada URL, que el método POST es correcto y 
	 el tipo de contenido de solicitud es correcto*/
	
	@Test
	public void cuandoEntradaValida_entoncesDevuelve200() throws Exception {
		
		logger.info("Aplicando test que devuelve 200");
		
		mockMvc.perform(post("/eventos/add")
				.content(objectMapper.writeValueAsString(evento))
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	public void cuandoEntradaNull_entoncesDevuelve400() throws Exception {
		
		logger.info("Aplicando test que devuelve 400");
		
		mockMvc.perform(post("/eventos/add")
				.content(objectMapper.writeValueAsString(eventoNull))
				.contentType("application/json"))
				.andExpect(status().isBadRequest());
	}

}
