package com.grupo2.eventos.service;


import java.util.List;

import com.grupo2.eventos.model.Evento;

public interface EventosServiceI {
	
	public Evento save (Evento evento);
	
	public List<Evento> findAll();

	public void deleteById(String id);

	public List<Evento> findAllByGenero(String genero);
}
