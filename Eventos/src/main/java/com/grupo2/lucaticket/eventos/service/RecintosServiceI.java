package com.grupo2.lucaticket.eventos.service;

import java.util.Optional;

import com.grupo2.lucaticket.eventos.model.Recinto;

public interface RecintosServiceI {

	public Optional<Recinto> findById(String id);

}
