package com.grupo2.lucaticket.usuarios.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo2.lucaticket.usuario.controller.UsuarioController;
import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.model.adapter.UsuarioAdapter;
import com.grupo2.lucaticket.usuario.model.response.UsuarioDto;
import com.grupo2.lucaticket.usuario.repository.UsuarioRepositoryI;
import com.grupo2.lucaticket.usuario.service.UsuarioServiceI;

/**
 * @Project LucaTicket
 *
 * @Classname UsuariosController
 *
 * @author Grupo 2 - Lamia
 *
 * @date 13/10/2022
 *
 * @since 1.0
 *
 */

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTestUnit {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioControllerTestUnit.class);

//Given
	
@Autowired
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

@MockBean
private UsuarioServiceI usuarioService;

@MockBean
private UsuarioAdapter usuarioAdapter;

@MockBean
private UsuarioRepositoryI usuarioRepositoryI;

Usuario usuario;
Usuario usuarioNull;
UsuarioDto usuarioDto;
UsuarioDto usuarioDtoNull;
Optional<Usuario> usuarios;
List<Usuario> usuariosVacio;

private final int ID = 1;
private final int ID_NULL = (Integer) null;
private final String NOMBRE = "nombre prueba";
private final String NOMBRE_NULL= null;
private final String APELLIDO = "apellido prueba";
private final String APELLIDO_NULL = null;
private final String EMAIL = "email@prueba.es";
private final String EMAIL_NULL = null;
private final String PASS = "passdeprueba";
private final String PASS_NULL = null;
private final LocalDate FECHAALTA = LocalDate.now(); 

void setUp() {
	// When
		/*
		 * Verifica que el controlador responde a una determinada URL, que el método
		 * POST es correcto y el tipo de contenido de solicitud es correcto
		 */
}
@Test
public void cuandoEntradaValida_entoncesDevuelve201() throws Exception{
	logger.info("Aplicando test que devuelve 201");
	
	// When
	when(usuarioService.save(usuario)).thenReturn(usuario);

	mockMvc.perform(
			post("/usuario/add").content(objectMapper.writeValueAsString(usuario)).contentType("application/json"))
			.andExpect(status().isCreated());
}

@Test
public void cuandoListaNull_Devuelve404() throws Exception {

	logger.info("Aplicando test que devuelve excepcion lista vacia");

	// when
	Collection<Usuario> usuarioVacio = null;
	when(usuarioService.findAll()).thenReturn(usuarioVacio);

	// then
	mockMvc.perform(get("/usuarios/lista").contentType("application/json")).andExpect(status().isNotFound());
	
}

/**
 * Descripción del método: Test que da Ok al eliminar un usuario
 * 
 * @author Grupo 2 - Lamia
 *
 * @version 1.0
 */

@Test
public void cuandoBorroUsuario_daOk() throws Exception{
	logger.info("Aplicando test que elimina un usuario");
	
	mockMvc.perform(delete("/usuarios/" + usuario.getId()).contentType("application/json"))
	.andExpect(status().isOk());
	
}

@Test
public void cuandoBorroUsuarioIdNull_da404() throws Exception {
	Usuario usuarioNull2 = new Usuario();
	usuarioNull2.setId(ID_NULL);
	usuarioNull2.setNombre(NOMBRE_NULL);
	usuarioNull2.setApellido(APELLIDO);
	usuarioNull2.setApellido(APELLIDO_NULL);
	usuarioNull2.setEmail(EMAIL);
	usuarioNull2.setEmail(EMAIL_NULL);
	usuarioNull2.setFechaalta(FECHAALTA);
	usuarioNull2.setPass(PASS);
	usuarioNull2.setPass(PASS_NULL);



	logger.info("Aplicando test que no elimina un evento por tener ID null");

	mockMvc.perform(delete("/eventos/" + usuarioNull2.getId()).contentType("application/json"))
			.andExpect(status().isNotFound());
}

/**
 * Descripción del método: Test que da ok cuando buscas un Usuario por ID.
 *
 * @author Grupo 2 - Lamia
 *
 * @version 1.0
 */

@Test
public void cuandoUsuarioPorId_Devuelve200() throws Exception {

	logger.info("Aplicando test que devuelve usuario por Id");

	// when
	when(usuarioService.findById(ID)).thenReturn(usuarios);

	// then
	mockMvc.perform(get("/usuarios/id/" + usuarioDto.getId()).contentType("application/json"))
			.andExpect(status().isOk());

}

/**
 * Descripción del método: Test que da NotFound cuando se busca un usuario por
 * ID null.
 *
 * @author Grupo 2 - Lamia
 *
 * @version 1.0
 */
@Test
public void cuandoEventoNombreNull_Devuelve404() throws Exception {

	logger.info("Aplicando test que devuelve excepcion ID no encontrado");

	// when
	when(usuarioService.findById(ID)).thenReturn(usuarios);

	// then
	mockMvc.perform(get("/usuarios/id/" + usuarioNull.getId()).contentType("application/json"))
			.andExpect(status().isNotFound());
}


}