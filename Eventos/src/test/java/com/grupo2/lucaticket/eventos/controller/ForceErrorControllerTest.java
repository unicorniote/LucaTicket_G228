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

import com.grupo2.lucaticket.eventos.controller.error.CiudadEventoNotFoundException;
import com.grupo2.lucaticket.eventos.controller.error.EventoNotFoundException;
import com.grupo2.lucaticket.eventos.controller.error.EventosEmptyDatabaseException;
import com.grupo2.lucaticket.eventos.controller.error.GeneroEventoNotFoundException;
import com.grupo2.lucaticket.eventos.controller.error.NombreEventoNotFoundException;

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

	@Test
	public void debeDevolverGeneroEventoNotFoundException() throws Exception {

		mvc.perform(get(puerto + "/eventos/generoEventoNotFoundException").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof GeneroEventoNotFoundException))
				.andExpect(result -> assertEquals("No hay ningún evento de ese género",
						result.getResolvedException().getMessage()));
	}

	@Test
	public void debeDevolverNombreEventoNotFoundException() throws Exception {

		mvc.perform(get(puerto + "/eventos/nombreEventoNotFoundException").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof NombreEventoNotFoundException))
				.andExpect(result -> assertEquals("No hay ningún evento con ese nombre",
						result.getResolvedException().getMessage()));
	}

	@Test
	public void debeDevolverCiudadEventoNotFoundException() throws Exception {

		mvc.perform(get(puerto + "/eventos/ciudadEventoNotFoundException").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof CiudadEventoNotFoundException))
				.andExpect(result -> assertEquals("No hay ningún evento en esa ciudad",
						result.getResolvedException().getMessage()));
	}

	@Test
	public void debeDevolverEventosEmptyDatabaseException() throws Exception {

		mvc.perform(get(puerto + "/eventos/eventosEmptyDatabaseException").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof EventosEmptyDatabaseException))
				.andExpect(result -> assertEquals("No hay eventos en la base de datos",
						result.getResolvedException().getMessage()));
	}

}
