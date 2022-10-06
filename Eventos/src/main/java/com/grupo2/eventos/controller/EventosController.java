package com.grupo2.eventos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.eventos.repository.EventosRepository;

/**
* @Project LucaTicket
*
* @Classname EventosController
*
* @author Grupo 2 -Carlos Jesús Pérez Márquez
*
* @date 06/10/2022
*
* @since 1.0
*
*/
@RestController
@RequestMapping("/eventos")
public class EventosController {

	private static final Logger log = LoggerFactory.getLogger(EventosController.class);
	
	@Autowired
	private EventosRepository eventosRepository;
	
	@Autowired
	
	private EventosService eventosService;
	
	
	
}
