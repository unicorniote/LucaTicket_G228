package com.grupo2.lucaticket.usuario.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.grupo2.lucaticket.usuario.controller.error.UsuarioNotFoundException;
import com.grupo2.lucaticket.usuario.controller.error.UsuariosEmptyDatabaseException;

@WebMvcTest(ForceErrorController.class)
public class ForceErrorControllerTest {

	@Autowired
	MockMvc mvc;

	private String puerto = "http://localhost:8080";

	@Test
	public void debeDevolverUsuarioNotFoundException() throws Exception {

		mvc.perform(get(puerto + "/usuario/usuarioNotFoundException").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof UsuarioNotFoundException))
				.andExpect(result -> assertEquals("Fail: Este usuario no existe",
						result.getResolvedException().getMessage()));
	}

	@Test
	public void debeDevolverUsuariosEmptyDatabaseException() throws Exception {

		mvc.perform(get(puerto + "/usuario/usuariosEmptyDatabaseException").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(
						result -> assertTrue(result.getResolvedException() instanceof UsuariosEmptyDatabaseException))
				.andExpect(result -> assertEquals("No hay usuarios en la base de datos",
						result.getResolvedException().getMessage()));
	}

}
