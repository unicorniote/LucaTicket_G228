package com.grupo2.lucaticket.eventos.service;

import java.util.List;

import com.grupo2.lucaticket.eventos.model.Evento;


/**
 * Interfaz EventosServiceI
 *
 * @author Grupo 2 - Lamia
 * @version 1.0 : 09/10/2022
 */
public interface EventosServiceI {
	
	public Evento save (Evento evento);
	
	public List<Evento> findAll();

	public void deleteById(String id);

	public List<Evento> findAllByGenero(String genero);
}
