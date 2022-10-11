package com.grupo2.lucaticket.usuario.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import com.grupo2.lucaticket.usuario.model.adapter.UsuarioAdapterI;
import com.grupo2.lucaticket.usuario.model.response.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.model.adapter.UsuarioAdapter;
import com.grupo2.lucaticket.usuario.service.UsuarioServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
* @Project LucaTicket
*
* @Classname UsuarioController
*
* @author Lamia
* 
* @date 07/10/2022
*
* @since 1.0
*
*/

@RestController
@Validated
@RequestMapping("/usuario")
@Tag(name= "Usuario Controller", description = "Listado de endpoints relacionados con Usuario")
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
		
	@Autowired
	private UsuarioServiceI usuarioService;
	
	@Autowired
	private UsuarioAdapterI usuarioAdapter;
	
	/**
	* Descripción del método:
	* Método que añade un usuario .
	* @param 
	* @return {@ResponseEntity} Se devuelve usuario
	* @author Lamia
	* @version 1.0
	*/
	@Operation(summary = "Añadir un usuario al archivo JSON",
			description = "Dado un usuario, se añade al archivo JSON que conforma la BBDD de MongoDB",
			tags={"Usuario"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "201",
			description = "Usuario guardado correctamente",
			content = {
					@Content(mediaType = "application/json",
					schema = @Schema(implementation = Usuario.class))}),

			@ApiResponse(responseCode = "400", description = "El evento no se ha añadido", content = @Content)})
	@PostMapping("/add")
	public ResponseEntity<?> addEvento( @RequestBody Usuario usuario){

		logger.info("añadiendo Usuario");
		usuario = this.usuarioService.save(usuario);
		logger.info("El usuario se ha añadido correctamente");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	/**
	* Método findById - Busca un usuario por su Id.
	* 
	* @return Devuelve un objeto usuarioDTO
	* 
	* @author Grupo 2 - Lamia
	* 
	* @version 1.0
	*/
	@Operation(summary = "Listar los usuarios",
			description = "Lista todo los eventos existentes en la BBDD de MySql",
			tags={"Usuario"})

	@ApiResponses(value= {
			@ApiResponse(responseCode = "201",
			description = "Eventos encontrados",
			content = {
					@Content(mediaType = "application/json",
					schema = @Schema(implementation = Usuario.class))}),
			@ApiResponse(responseCode = "400", description = "No existen usuarios en la bbdd", content = @Content)})
	@GetMapping ("/listar")
	public Collection<UsuarioDto> getEventos() {
		logger.info("Buscando usuario");
		return usuarioAdapter.usuarioToDto((List<Usuario>) usuarioService.findAll());
	}
}