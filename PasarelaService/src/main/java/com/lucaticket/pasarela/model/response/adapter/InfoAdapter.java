package com.lucaticket.pasarela.model.response.adapter;

import com.lucaticket.pasarela.model.response.InfoCompraDto;
import com.lucaticket.pasarela.model.response.VentasDto;
import org.springframework.stereotype.Component;

@Component
public class InfoAdapter implements InfoAdapterI{

    @Override
    public InfoCompraDto of(VentasDto ventasDto) {
        InfoCompraDto info = new InfoCompraDto();
        info.setUsuario(ventasDto.getUsuario().getNombre() + " " + ventasDto.getUsuario().getApellido());
        info.setEvento(ventasDto.getEvento().getNombre());
        info.setRecinto(ventasDto.getEvento().getRecintoEvento());
        info.setPrecio(ventasDto.getEvento().getRangoPreciosEvento());
        info.setFecha(ventasDto.getEvento().getFechaEvento());
        return info;
    }
}
