package com.grupo2.lucaticket.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucaticket.usuario.model.Usuario;

/**
 * Interfaz UsuarioRepositoryI que se encarga de gestionar las consultas a la tabla Usuario de la BBDD
 *
 * @author Grupo 2 - Alonso
 * @version 2.0 : 07/10/2022
 */
public interface UsuarioRepositoryI extends JpaRepository<Usuario, Integer> {

}
