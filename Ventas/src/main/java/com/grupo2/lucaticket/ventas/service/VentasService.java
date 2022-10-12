package com.grupo2.lucaticket.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupo2.lucaticket.ventas.model.Venta;
import com.grupo2.lucaticket.ventas.repository.VentasRepositoryI;

public class VentasService implements VentasServiceI{ 
	@Autowired
	private VentasRepositoryI repo;

	@Override
	public Venta addVenta(Venta venta) {
		return repo.save(venta);
	}

	

}
