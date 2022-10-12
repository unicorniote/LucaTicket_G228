package com.grupo2.lucaticket.eventos.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.grupo2.lucaticket.eventos.model.Evento;
import com.grupo2.lucaticket.eventos.model.response.EventoDto;



/**
* @Project LucaTicket
*
* Interfaz EventosServiceI
*
* @author Lamia
* @date 11/10/2022
*
* @since 1.0
*
*/
public interface EventosServiceI {
	
	public Evento save (Evento evento);
	
	public List<Evento> findAll();

	public void deleteById(String id);

	public List<Evento> findAllByGenero(String genero);
	
	public List<Evento> findByNombre(String nombre);
	
	public Optional<Evento> findById(String id);
	
	public List<Evento> findByCiudad(String ciudad);
}
		

	
