package com.grupo2.lucaticket.ventas.model.response.adapter;


import com.grupo2.lucaticket.ventas.model.Venta;
import com.grupo2.lucaticket.ventas.model.response.EventoDto;
import com.grupo2.lucaticket.ventas.model.response.UsuarioDto;
import com.grupo2.lucaticket.ventas.model.response.VentasDto;

public class VentasAdapter implements VentasAdapterI{
    /**
     * Metodo para crear un Objeto VentasDto partiendo de una venta, un usuario y un evento
     * @param venta la venta con el id
     * @param usuario el dto del usuario obtenido desde el servicio
     * @param evento el dto del evento obtenido desde el servicio
     * @return {@link VentasDto} con toda la informacion
     *
     * @author Grupo 2 - Alonso
     * @version 1.0 : 13/10/2022
     */
    @Override
    public VentasDto of(Venta venta, UsuarioDto usuario, EventoDto evento) {
        VentasDto ventasDto = new VentasDto();
        ventasDto.setUsuario(usuario);
        ventasDto.setEvento(evento);
        return ventasDto;
    }
}
