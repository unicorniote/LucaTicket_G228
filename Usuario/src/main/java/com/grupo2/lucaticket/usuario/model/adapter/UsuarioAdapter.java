package com.grupo2.lucaticket.usuario.model.adapter;

import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.model.response.UsuarioDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Clase para adaptar entidades Usuario a Objetos DTO de Usuarios
 *
 * @author Grupo 2 - Alonso Gómez
 * @version 1.0 : 07/10/2022
 */
@Component
public class UsuarioAdapter implements UsuarioAdapterI {


    private static final Logger logger = LoggerFactory.getLogger(UsuarioAdapter.class);

    /**
     * Metodo que devuelve el DTO del Usuario pasado
     * @param usuario La entidad que queremos convertir al DTO
     * @return El objeto DTO correspondiente a la entidad pasada
     * @since 1.0
     */
   @Override
    public UsuarioDto usuarioToDto(Usuario usuario) {
        logger.info("Mapeando objeto entidad Usuario a DTO de Usuario...");
        UsuarioDto response = new UsuarioDto();
        response.setId(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setApellido(usuario.getApellido());
        response.setEmail(usuario.getEmail());
        response.setPass(usuario.getPass());
        response.setFechaalta(usuario.getFechaalta());
        return response;
    }

    /**
     * Metodo que devuelve una lista de DTO de Usuarios dada una lista de Entidades Usuario
     * @param usuarios Lista de entidades
     * @return Lista de DTOs
     * @since 1.0
     */
    @Override
    public List<UsuarioDto> usuarioToDto(List<Usuario> usuarios) {
        logger.info("Mapeando lista de entidades Usuario a lista de DTO de Usuarios");
        return usuarios.stream().map(this::usuarioToDto).toList();
    }
	

	
}
