package com.grupo2.lucaticket.usuario.model.adapter;

import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.model.response.UsuarioDto;

import java.util.List;

public interface UsuarioAdapterI {

    public UsuarioDto usuarioToDto(Usuario usuario);

    /**
	 * Metodo que devuelve el DTO del Usuario pasado
	 * @param usuario La entidad que queremos convertir al DTO
	 * @return El objeto DTO correspondiente a la entidad pasada
	 * @since 1.0
	 */
    public List<UsuarioDto> usuarioToDto(List<Usuario> usuarios);
    
}
