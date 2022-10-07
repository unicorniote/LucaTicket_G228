package com.grupo2.eventos.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FechaUtilsTestUnit {

	LocalDateTime fecha;

	@BeforeEach
	void setUp() {
		// Given
		fecha = LocalDateTime.of(2022, 10, 7, 10, 50);

	}

	@Test
	void shouldRetunrnStringFromDate() {

		// When
		String fechaString = "07/10/2022 10:50";

		// Then
		assertThat(FechaUtils.formatearFecha(fecha)).isEqualTo(fechaString);
	}

}
