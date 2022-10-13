package com.grupo2.lucaticket.usuario.model.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.grupo2.lucaticket.usuario.model.Usuario;


/**
 * @Project LucaTicket
 *
 * @Classname UsuarioDto Test Unit
 *
 * @author Grupo 2 - Lamia
 *
 * @date 13/10/2022
 *
 * @since 1.0
 *
 */
@ExtendWith(MockitoExtension.class)
public class UsuarioDtoTestUnit {
	
	//Given
	@InjectMocks
	UsuarioDto usuario;
	
	//Valores 
	

private final int ID = 1;
private final String NOMBRE = "nombre prueba";
private final String APELLIDO = "apellido prueba";
private final String EMAIL = "email@prueba.es";
private final String PASS = "passdeprueba";
private final LocalDate FECHAALTA = LocalDate.now(); 


@BeforeEach
void setUp() {
	
	

//UsuarioDTO
	usuario = new UsuarioDto();
	usuario.setNombre(NOMBRE);
	usuario.setApellido(APELLIDO);
	
	

}

@Test
void userDtoExist() {
	assertThat(usuario).isNotNull();
}

@Test
void userDtoShouldHaveNombre() {
	
	//When 
	usuario.setNombre(NOMBRE);
	
	//Then
	assertThat(usuario.getNombre()).isEqualTo(NOMBRE);
	
}

@Test
void userDtoShouldHaveApellido() {
	
	//When 
	usuario.setApellido(APELLIDO);
	
	//Then
	assertThat(usuario.getApellido()).isEqualTo(APELLIDO);
	
}

}
