package com.grupo2.lucaticket.eventos.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.grupo2.lucaticket.eventos.controller.error.EventoNotFoundException;

@WebMvcTest(ForceErrorController.class)
public class ForceErrorControllerTest {

	@Autowired
	MockMvc mvc;

	private String puerto = "http://localhost:8080";

	@Test
	public void debeDevolverEventoNotFoundException() throws Exception {

		mvc.perform(get(puerto + "/eventos/eventoNotFoundException").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof EventoNotFoundException))
				.andExpect(result -> assertEquals("Este evento no existe en la base de datos.",
						result.getResolvedException().getMessage()));
	}

}
