package com.grupo2.eventos.service;

import java.util.Collection;

import com.grupo2.eventos.model.Evento;

public interface EventosServiceI {
	
	public Evento save (Evento evento);
	
	public Collection<Evento> findAll();

}
