package com.grupo2.lucaticket.ventas.model.response.adapter;

import com.grupo2.lucaticket.ventas.model.Venta;
import com.grupo2.lucaticket.ventas.model.response.EventoDto;
import com.grupo2.lucaticket.ventas.model.response.UsuarioDto;
import com.grupo2.lucaticket.ventas.model.response.VentasDto;

public interface VentasAdapterI {

    public VentasDto of(Venta venta, UsuarioDto usuario, EventoDto evento);
}
