package com.lucaticket.pasarela.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomUtils implements RandomUtilsI {

	@Override
	public int numeroAleatorio(int min, int max) {
		// TODO Auto-generated method stub
		Random numeroRandom = new Random();
		return numeroRandom.nextInt((max - min) + 1) + min;
	}

}
