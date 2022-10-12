package com.grupo2.lucaticket.usuario.model.adapter;

import com.grupo2.lucaticket.usuario.model.Usuario;
import com.grupo2.lucaticket.usuario.model.response.UsuarioDto;

import java.util.List;

/**
 * @Project LucaTicket
 *
 * @Classname Usuario
 *
 * @Author Grupo 2 - Lamia
 *
 * @Date 11/10/2022
 */
public interface UsuarioAdapterI {

	public UsuarioDto usuarioToDto(Usuario usuario);

	public List<UsuarioDto> usuarioToDto(List<Usuario> usuarios);

	public UsuarioDto usuarioToVentasDto(Usuario usuario);

	public List<UsuarioDto> usuarioToVentasDto(List<Usuario> usuarios);
}
