package com.grupo2.lucaticket.ventas.service;

import com.grupo2.lucaticket.ventas.controller.VentasController;
import com.grupo2.lucaticket.ventas.feignclients.UsuarioFeignClients;
import com.grupo2.lucaticket.ventas.model.response.UsuarioDto;
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

	@Autowired
	private UsuarioFeignClients feignClients;

	@Override
	public Venta addVenta(Venta venta) {
		logger.info("Comprobando usuario " + venta.getUsuario());
		final UsuarioDto usuarioDto = feignClients.getUsuario(venta.getUsuario()); // controlar excepciones que vengan desde usuario
		logger.info("usuario encontrado ->: " + usuarioDto);
		// falta comprobar que el evento exista
		if (usuarioDto != null) {
			venta = repo.save(venta);
		}

		return venta;
	}

	

}
