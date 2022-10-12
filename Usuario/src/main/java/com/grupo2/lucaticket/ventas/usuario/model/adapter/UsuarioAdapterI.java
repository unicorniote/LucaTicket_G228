package com.grupo2.lucaticket.ventas.usuario.model.adapter;

import com.grupo2.lucaticket.ventas.usuario.model.Usuario;
import com.grupo2.lucaticket.ventas.usuario.model.response.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface UsuarioAdapterI {

    public UsuarioDto usuarioToDto(Optional<Usuario> optional);

    public List<UsuarioDto> usuarioToDto(List<Usuario> usuarios);

	/**
	 * Metodo que devuelve el DTO del Usuario pasado
	 * @param usuario La entidad que queremos convertir al DTO
	 * @return El objeto DTO correspondiente a la entidad pasada
	 * @since 1.0
	 */
	UsuarioDto usuarioToDto(Usuario usuario);

	/**
	 * Metodo que devuelve el DTO del Usuario pasado
	 * @param usuario La entidad que queremos convertir al DTO
	 * @return El objeto DTO correspondiente a la entidad pasada
	 * @since 1.0
	 */

	
	
}
