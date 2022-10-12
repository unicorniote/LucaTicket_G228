package com.grupo2.lucaticket.ventas.usuario.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grupo2.lucaticket.ventas.usuario.model.Usuario;
import com.grupo2.lucaticket.ventas.usuario.repository.UsuarioRepositoryI;

/**
 * @author Grupo 2 - Alonso
 * @version 1.0 : 07/10/2022
 */
@Service
public class UsuarioService implements UsuarioServiceI {

	@Autowired
	private UsuarioRepositoryI repo;

	/**
	 * Metodo que guarda en la BBDD el usuario pasado como parametro
	 *
	 * @param usuario El usuario que se quiere guardar en la BBDD
	 * @return El usuario con los atributos actualizados de la BBDD
	 * @since 1.0
	 */
	@Override
	public Usuario save(Usuario usuario) {
		return repo.save(usuario);
	}

	@Override
	public Collection<Usuario> findAll() {
		return repo.findAll();
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Optional<Usuario> findById(String id) {
		return repo.findById(id);
	}



	
	
}
