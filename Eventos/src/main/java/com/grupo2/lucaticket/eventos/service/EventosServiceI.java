package com.grupo2.lucaticket.eventos.service;

import java.util.List;
import java.util.Optional;

import com.grupo2.lucaticket.eventos.model.Evento;

public interface EventosServiceI {
	
	public Evento save (Evento evento);
	
	public List<Evento> findAll();

	public void deleteById(String id);

	public List<Evento> findAllByGenero(String genero);
	
	public Optional<Evento> findByNombre(String nombre);
	
	public Optional<Evento> findById(String id);
	
	public Optional<Evento> findByCiudad(String ciudad);
}
