package com.lucaticket.pasarela.model.response.adapter;

import com.lucaticket.pasarela.model.response.InfoCompraDto;
import com.lucaticket.pasarela.model.response.VentasDto;

public interface InfoAdapterI {

    public InfoCompraDto of(VentasDto ventasDto);
}
