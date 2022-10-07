package com.grupo2.eventos.model.adapter;

import java.util.List;

import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.model.response.EventoDto;

public interface EventoAdapterI {

	public EventoDto EventoToDto(Evento evento);

	public List<EventoDto> EventoToDto(List<Evento> eventos);

}
