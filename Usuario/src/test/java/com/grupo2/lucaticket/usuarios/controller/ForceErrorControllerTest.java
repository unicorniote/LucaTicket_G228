package com.grupo2.lucaticket.usuarios.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.grupo2.lucaticket.usuario.controller.ForceErrorController;
import com.grupo2.lucaticket.usuario.controller.error.UsuarioNotFoundException;

/**
 * @Project LucaTicket
 *
 * @Classname ForceErrorController
 *
 * @author Grupo 2 - Lamia
 *
 * @date 13/10/2022
 *
 * @since 1.0
 *
 */
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
				.andExpect(result -> assertEquals("Este usuario no existe en la base de datos.",
						result.getResolvedException().getMessage()));
	}


}
