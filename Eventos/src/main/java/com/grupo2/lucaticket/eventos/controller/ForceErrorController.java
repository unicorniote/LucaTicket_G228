package com.grupo2.lucaticket.eventos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.lucaticket.eventos.controller.error.EventoNotFoundException;

@RestController
public class ForceErrorController {

	@GetMapping(value = "/eventos/eventoNotFoundException")
	public void throwException() {
		throw new EventoNotFoundException();
	}
}