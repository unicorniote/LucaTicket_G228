package com.lucaticket.pasarela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaticket.pasarela.repository.ValidarPagosRepositoryI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ValidarPagosServiceImpl implements ValidarPagosService {

	@Autowired
	ValidarPagosRepositoryI validarRepository;

	@Override
	public int encontrarTarjeta() {
		log.info("Pidiendo información de tarjeta a la base de datos...");
		return validarRepository.encontrarTarjeta();
	}

	@Override
	public int consultarFondos() {
		log.info("Pidiendo información de fondos a la base de datos...");
		return validarRepository.consultarFondos();
	}

	@Override
	public int validarCvv() {
		// TODO Auto-generated method stub
		log.info("Pidiendo información de CVV a la base de datos...");
		return validarRepository.validarCvv();
	}

}
