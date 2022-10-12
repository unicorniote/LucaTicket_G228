package com.grupo2.lucaticket.usuario.service;



import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;


import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.model.response.UsuarioDto;

public interface UsuarioServiceI {

    public Usuario save(@Valid Usuario usuario);

    public Collection<Usuario> findAll();
    
    public void deleteById (String id);

	public Optional<Usuario> findById(String id);
	
	public Optional <UsuarioDto> update(@Valid UsuarioDto usuario);


}
