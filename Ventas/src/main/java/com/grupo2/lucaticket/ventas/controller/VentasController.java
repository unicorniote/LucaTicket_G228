package com.grupo2.lucaticket.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.lucaticket.ventas.service.VentasServiceI;


/**
* @Project LucaTicket
*
* @Classname VentasController
*
* @author Lamia
* 
* @date 11/10/2022
*
* @since 1.0
*
*/

@RestController
@RequestMapping("/ventas")
public class VentasController {

	
	@Autowired 
	private VentasServiceI ventasService;

	
	
}
