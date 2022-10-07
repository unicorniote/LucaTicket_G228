package com.grupo2.lucaticket.usuario.repository;

import com.grupo2.lucaticket.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepositoryI extends JpaRepository<Usuario, Integer> {

}
