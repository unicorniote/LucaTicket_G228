package com.grupo2.lucaticket.eventos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucaticket.eventos.model.Recinto;
import com.grupo2.lucaticket.eventos.repository.RecintosRespositoryI;

@Service
public class RecintosService implements RecintosServiceI {

	@Autowired
	RecintosRespositoryI recintoRepository;
	
	@Override
	public Optional<Recinto> findById(String id) {
		// TODO Auto-generated method stub
		
		return recintoRepository.findById(id);
	}

}
