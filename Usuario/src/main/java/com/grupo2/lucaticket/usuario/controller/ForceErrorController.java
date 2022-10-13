package com.grupo2.lucaticket.usuario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.lucaticket.usuario.controller.error.UsuarioNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * Controlador con los endpoints que lanzan las excepciones personalizadas.
 *
 * @author Álvaro Román
 * @version 13/10/2022
 */
@RestController
@Slf4j
@Tag(name = "Controlador ForceErroController", description = "Controlador que lanza errores personalizados de Usuarios")
public class ForceErrorController {

	/**
	 * Método que devuelve la excepción personalizada EventoNotFoundException
	 * 
	 * @throws EventoNotFoundException
	 * @author Álvaro Román
	 * @version 1.0
	 */
	@Operation(summary = "Lanza una excepción UsuarioNotFoundException", description = "Permite lanzar una excepción de UsuarioNotFoundException", tags = {
			"UsuarioNotFoundException" })
	@ApiResponse(responseCode = "404", description = "El usuario no existe ne la base de datos", content = {
			@Content() })
	@GetMapping(value = "/usuario/usuarioNotFoundException")
	public void throwEventoNotFoundException() {
		log.info("Lanzando exception UsuarioNotFoundException...");
		throw new UsuarioNotFoundException();
	}

}