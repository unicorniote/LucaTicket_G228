package com.grupo2.lucaticket.eventos.service;

import java.util.List;

import com.grupo2.lucaticket.eventos.model.Evento;

public interface EventosServiceI {
	
	public Evento save (Evento evento);
	
	public List<Evento> findAll();

	public void deleteById(String id);

}
