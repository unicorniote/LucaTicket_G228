package com.grupo2.lucaticket.usuario.service;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import com.grupo2.lucaticket.usuario.controller.UsuarioDto;
import com.grupo2.lucaticket.usuario.model.Usuario;

public interface UsuarioServiceI {

	public Usuario save(@Valid Usuario usuario);

	public Collection<Usuario> findAll();

	 //public Collection<UsuarioDto> usuarioToDto(List<Usuario> usuario);

}
