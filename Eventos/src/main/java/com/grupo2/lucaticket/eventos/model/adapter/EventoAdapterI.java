package com.grupo2.lucaticket.eventos.model.adapter;

import java.util.List;

import com.grupo2.lucaticket.eventos.model.Evento;
import com.grupo2.lucaticket.eventos.model.response.EventoDto;

public interface EventoAdapterI {

	public EventoDto eventoToDto(Evento evento);

	public List<EventoDto> eventoToDto(List<Evento> eventos);

}
