package com.grupo2.lucaticket.usuario.model.adapter;

import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.model.response.UsuarioResponse;

import java.util.List;

public interface UsuarioAdapterI {

    public UsuarioResponse usuarioToDto(Usuario usuario);

    public List<UsuarioResponse> usuarioToDto(List<Usuario> usuarios);
}
