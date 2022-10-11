package com.grupo2.eventos.service;


import java.util.List;
import java.util.Optional;

import com.grupo2.eventos.model.Evento;

public interface EventosServiceI {
	
	public Evento save (Evento evento);
	
	public List<Evento> findAll();

	public void deleteById(String id);
	
	public Optional<Evento> findByNombre(String nombre);

	public List<Evento> findAllByGenero(String genero);
	
	public Optional<Evento> findById(String id);
}
