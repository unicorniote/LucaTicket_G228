package com.lucaticket.pasarela.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ValidarPagosRespositoryTest {

	@Mock
	ValidarPagosRepositoryI validarRepository;

//	@BeforeEach
//	public

	@Test
	public void debeHaberSaldo() {

		// When
		when(validarRepository.consultarFondos()).thenReturn(1);

		assertThat(validarRepository.consultarFondos()).isEqualTo(1);

	}

}
