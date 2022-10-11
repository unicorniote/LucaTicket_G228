package com.grupo2.lucaticket.ventas.usuario.service;

import java.util.Collection;

import javax.validation.Valid;


import com.grupo2.lucaticket.ventas.usuario.model.Usuario;

public interface UsuarioServiceI {

    public Usuario save(@Valid Usuario usuario);

    public Collection<Usuario> findAll();
    
    public void deleteById (int id);
}
