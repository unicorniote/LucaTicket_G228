package com.grupo2.lucaticket.ventas.model.response.adapter;

import com.grupo2.lucaticket.ventas.model.response.EventoDto;
import com.grupo2.lucaticket.ventas.model.response.EventoResponseDto;

public interface EventoAdapterI {

    public EventoDto of(EventoResponseDto responseDto);
}
