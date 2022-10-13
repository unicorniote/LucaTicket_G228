package com.grupo2.lucaticket.ventas.service;

import com.grupo2.lucaticket.ventas.controller.VentasController;
import com.grupo2.lucaticket.ventas.feignclients.EventoFeignClient;
import com.grupo2.lucaticket.ventas.feignclients.UsuarioFeignClients;
import com.grupo2.lucaticket.ventas.model.response.EventoResponseDto;
import com.grupo2.lucaticket.ventas.model.response.UsuarioDto;
import com.grupo2.lucaticket.ventas.model.response.VentasDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupo2.lucaticket.ventas.model.Venta;
import com.grupo2.lucaticket.ventas.repository.VentasRepositoryI;
import org.springframework.stereotype.Service;

/**
* @Project LucaTicket
*
* @Classname VentasService
*
* @author Alonso
* 
* @date 11/10/2022
*
* @since 1.0
*
*/
@Service
public class VentasService implements VentasServiceI{

	private static final Logger logger = LoggerFactory.getLogger(VentasController.class);

	@Autowired
	private VentasRepositoryI repo;


	@Override
	public Venta addVenta(Venta venta) {
		return repo.save(venta);
	}

	

}
