package com.grupo2.lucaticket.usuario.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.repository.UsuarioRepositoryI;

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
	/**
	 * Metodo para encontrar usuarios
	 * @param usuario 
	 * @return Lista d usuarios
	 * @since 1.0
	 */
	@Override
	public Collection<Usuario> findAll() {
		return repo.findAll();
	}

	/**
	 * Metodo para eliminar un usuario por su ID
	 * @param usuario 
	 * @return Lista d usuarios
	 * @since 1.0
	 */
	
	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	/**
	 * Metodo para encontrar un  usuario por su ID
	 * @param usuario 
	 * @return un usuario por ID
	 * @since 1.0
	 */
	public Optional<Usuario> findById(int id) {
		return repo.findById(id);
	}
	
	/**
	 * Metodo para modificar un  usuario por su ID
	 *
	 * @param usuario
	 * @return usuario
	 * @since 1.0
	 */

	@Override
	public Usuario update(Usuario usuario) {
		return repo.save(usuario);
	}

	/**
	 * Metodo que elimina un usuario
	 *
	 * @param UsuarioDto
	 * @return usuario
	 * @since 1.0
	 */
	
	
	@Override
    public void deleteUsuario(int id) {
		repo.deleteById(id);
    }
}
