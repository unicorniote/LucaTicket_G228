package com.grupo2.eventos.controller.error;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomErrorJsonTestUnit {

	private CustomErrorJson customError;

	@BeforeEach
	void setUp() {
		customError = new CustomErrorJson();
	}

	@Test
	void customErrorJsonShouldExists() {

		assertThat(customError).isNotNull();

	}

	@Test
	void eventDtoShouldBeCreated() {

		// Given
		ArrayList<String> mensajes = new ArrayList<>();
		mensajes.add("Mensajes1");
		mensajes.add("Mensajes2");
		CustomErrorJson customErroCompleto = new CustomErrorJson(LocalDateTime.now(), 200, "Error", mensajes, "Ruta");

		// Then
		assertThat(customErroCompleto).isNotNull();

	}

}
