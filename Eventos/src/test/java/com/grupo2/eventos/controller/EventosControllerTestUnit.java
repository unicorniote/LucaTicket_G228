package com.grupo2.eventos.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.model.adapter.EventoAdapter;
import com.grupo2.eventos.service.EventosServiceI;



@WebMvcTest(EventosController.class)
public class EventosControllerTestUnit {

	@MockBean
	Evento evento = new Evento();
	//Given 
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EventoAdapter eventoAdapter;
	
	@MockBean
	private EventosServiceI eventosService;
	
	
	
	//When
	
	@Test
	public void verificarMetodoPostMappingAddEsOk() throws Exception {
		mockMvc.perform(post("/evento/add")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	
}
