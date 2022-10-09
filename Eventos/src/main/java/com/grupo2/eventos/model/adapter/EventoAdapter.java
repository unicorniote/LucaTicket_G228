package com.grupo2.eventos.model.adapter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.model.response.EventoDto;

/**
 * Clase EventoAdapter que contiene los métodos para pasar de entidad Evento a
 * objeto DTO.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 06/10/2022
 */
@Component
public class EventoAdapter implements EventoAdapterI {

	private static final Logger logger = LoggerFactory.getLogger(EventoAdapter.class);

	/**
	 * Método EventoToDto que devuelve un objeto DTO de Evento a partir de una
	 * entidad Evento.
	 * 
	 * @param evento - Objeto de tipo entidad Evento
	 * @return EventoDto
	 * @author Álvaro Román Gómez
	 * @version 1.0
	 */
	@Override
	public EventoDto eventoToDto(Evento evento) {
		// TODO Auto-generated method stub
		logger.info("Mapeando objeto entidad Evento a DTO de Evento...");
		EventoDto eventoDto = new EventoDto();


		eventoDto.setNombre(evento.getNombre());
		eventoDto.setDescripcionEvento(evento.getDescripcionCorta());
		eventoDto.setFoto(evento.getFoto());
		eventoDto.setFechaEvento(evento.getFechaEvento().toLocalDate());
		eventoDto.setHoraEvento(evento.getFechaEvento().toLocalTime());
		eventoDto.setRangoPreciosEvento(evento.getPrecio());
		eventoDto.setPolitcaAcceso(evento.getPolitaAcceso());
		eventoDto.setRecintoEvento(evento.getRecinto().getNombreRecinto());
		eventoDto.setCiudadEvento(evento.getRecinto().getCiudad());
		eventoDto.setDireccionEvento(evento.getRecinto().getDireccion());
		eventoDto.setAforoEvento(evento.getRecinto().getAforo());
		eventoDto.setGenero(evento.getGenero());

		return eventoDto;
	}

	/**
	 * Método EventoToDto que devuelve una lista de objetos DTO de Evento a partir
	 * de una lista de entidades Evento.
	 * 
	 * @param eventos - Lista de objetos de entidades Evento
	 * @return List<EventoDto>
	 * @author Álvaro Román Gómez
	 * @version 1.0
	 */
	@Override
	public List<EventoDto> eventoToDto(List<Evento> eventos) {
		// TODO Auto-generated method stub
		logger.info("Mapeando lista de entidades Evento a lista de objetos DTO EventoDto...");
		List<EventoDto> eventosDto = new ArrayList<>();

		for (Evento evento : eventos) {
			eventosDto.add(this.eventoToDto(evento));
		}

		return eventosDto;
	}

}
