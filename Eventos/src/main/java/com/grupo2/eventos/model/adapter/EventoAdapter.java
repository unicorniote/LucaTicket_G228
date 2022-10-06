package com.grupo2.eventos.model.adapter;

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
	public EventoDto EventoToDto(Evento evento) {
		// TODO Auto-generated method stub
		logger.info("Mapeando objeto entidad Evento a DTO de Evento...");
		EventoDto eventoDto = new EventoDto();

		eventoDto.setId(evento.getID());
		eventoDto.setNombreEvento(evento.getNombre());
		eventoDto.setDescripcionEvento(evento.getDescripCorta());
		eventoDto.setFoto(evento.isFoto());
		eventoDto.setFechaEvento(evento.getFechaEvento());
		eventoDto.setHoraEvento(evento.getHoraEvento());
		eventoDto.setRangoPreciosEvento(evento.getRangoPrecio());
		eventoDto.setPolitcaAcceso(evento.getPoliticaAcceso());
		eventoDto.setRecintoEvento(evento.getRecinto().getNomRecinto());
		eventoDto.setCiudadEvento(evento.getRecinto().getCiudad());
		eventoDto.setDireccionEvento(evento.getRecinto().getDireccion());
		eventoDto.setAforoEvento(evento.getRecinto().getAforo());
		eventoDto.setGenero(evento.getGenero());

		return eventoDto;
	}

}
