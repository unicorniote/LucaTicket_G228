package com.grupo2.lucaticket.eventos.service;

import java.util.Optional;

import org.bson.types.ObjectId;

import com.grupo2.lucaticket.eventos.model.Recinto;

public interface RecintosServiceI {

	public Optional<Recinto> findById(String string);

}
