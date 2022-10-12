package com.lucaticket.pasarela.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lucaticket.pasarela.utils.RandomUtilsI;

@Repository
public class ValidarPagosRespository implements ValidarPagosRepositoryI {

	@Autowired
	RandomUtilsI randomUtils;

	@Override
	public int consultarFondos() {
		// TODO Auto-generated method stub

		return randomUtils.numeroAleatorio(1, 10);
	}

	@Override
	public int encontrarTarjeta() {
		// TODO Auto-generated method stub
		return randomUtils.numeroAleatorio(1, 20);
	}

	@Override
	public int validarCvv() {
		// TODO Auto-generated method stub
		return randomUtils.numeroAleatorio(1, 5);
	}

}
