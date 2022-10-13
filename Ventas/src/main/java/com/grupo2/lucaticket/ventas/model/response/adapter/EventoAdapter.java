package com.grupo2.lucaticket.ventas.model.response.adapter;

import com.grupo2.lucaticket.ventas.model.response.EventoDto;
import com.grupo2.lucaticket.ventas.model.response.EventoResponseDto;
import org.springframework.stereotype.Component;

@Component
public class EventoAdapter implements EventoAdapterI {
    /**
     * Metodo para crear un dto simplificado de la respuesta del servicio
     * @param responseDto la respuesta detallada del servicio
     * @return el dto simplificado
     *
     * @author Grupo 2 - Alonso
     * @version 1.0 : 13/10/2022
     */
    @Override
    public EventoDto of(EventoResponseDto responseDto) {
        EventoDto eventoDto = new EventoDto();
        eventoDto.setNombre(responseDto.getNombre());
        eventoDto.setDescripcionEvento(responseDto.getDescripcionEvento());
        eventoDto.setFechaEvento(responseDto.getFechaEvento());
        return eventoDto;
    }
}
