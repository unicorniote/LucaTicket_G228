package com.grupo2.eventos.controller;


import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.grupo2.eventos.model.Evento;



@WebMvcTest(EventosController.class)
public class EventosControllerTestUnit {

	//Given 
	
	@Mock
	private MockMvc mockMvc;
	
	@Mock
	private Evento evento;
	
	@BeforeAll
	public void setUp() throws Exception{
		mockMvc=MockMvcBuilders.standaloneSetup(evento).build();
	}
	
	@Test
	public void testPostMappingAdd() throws Exception{
		mockMvc.perform(post("evento//add").content(MediaType.APPLICATION_JSON))
	}
	
	
	
}
