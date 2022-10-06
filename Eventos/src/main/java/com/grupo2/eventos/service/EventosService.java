package com.grupo2.eventos.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.eventos.model.Evento;

@Service
public class EventosService implements EventosServiceI {

	@Autowired
	private EventosAdapter eventosAdapter;

	@Override
	public Collection<Evento> findAll() {
		return eventosAdapter.findAll();
	}

}
