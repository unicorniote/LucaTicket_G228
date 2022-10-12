package com.lucaticket.pasarela.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class ValidationUtils {

	public static boolean validarTarjeta(int numero) {
		// TODO Auto-generated method stub
		log.info("Validando número de tarjeta...");

		if (numero == 1) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean validarCvv(int numero) {
		// TODO Auto-generated method stub
		log.info("Valindado CVV de la tarjeta...");

		if (numero == 1) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean validarFondos(int numero) {
		// TODO Auto-generated method stub
		log.info("Comprobando fondos disponibles...");
		if (numero == 1) {
			return false;
		} else {
			return true;
		}
	}

}
