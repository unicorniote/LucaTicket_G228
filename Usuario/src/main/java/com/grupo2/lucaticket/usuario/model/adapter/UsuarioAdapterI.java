package com.grupo2.lucaticket.usuario.model.adapter;

import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.model.response.UsuarioDto;

import java.util.List;

public interface UsuarioAdapterI {

    public UsuarioDto usuarioToDto(Usuario usuario);

    public List<UsuarioDto> usuarioToDto(List<Usuario> usuarios);
    
}
