package com.grupo2.lucaticket.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired 
	private VentasService ventasService;

	
	
}
