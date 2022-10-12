package com.grupo2.lucaticket.usuario.service;






/**
* @Project LucaTicket
*
* Interfaz UsuarioServiceI
*
* @author Alonso
* @date 07/10/2022
*
* @since 1.0
*
*/
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;


import com.grupo2.lucaticket.usuario.model.Usuario;

public interface UsuarioServiceI {

	/**
	 * Metodo que guarda un usuario
	 *
	 * @param Usuario
	 * @return usuario
	 * @since 1.0
	 */
    public Usuario save(Usuario usuario);

    /**
	 * Metodo que devuelve la lista de usuarios
	 *
	 * @param Usuario
	 * @return Lista de usuarios
	 * @since 1.0
	 */
    public Collection<Usuario> findAll();
    
    /**
	 * Metodo que elimina un usuario por su ID
	 *
	 * @param Usuario
	 * @return usuario
	 * @since 1.0
	 */
    public void deleteById (int id);

    /**
	 * Metodo que encuentra un usuario por su ID
	 *
	 * @param Usuario
	 * @return usuario
	 * @since 1.0
	 */
	public Optional<Usuario> findById(int id);
	
	/**
     * Metodo que modifica un usuario
     *
     * @param UsuarioDto
     * @return usuario
     * @since 1.0
     */
	public Usuario update(Usuario usuario);

	/**
	 * Metodo que elimina un usuario
	 *
	 * @param UsuarioDto
	 * @return usuario
	 * @since 1.0
	 */
	public void deleteUsuario(int id);

}