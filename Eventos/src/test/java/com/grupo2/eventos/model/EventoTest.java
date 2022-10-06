package com.grupo2.eventos.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EventoTest {
	
	//Given
	@Mock
	private Evento evento;
	
	@Test
	void eventoDeberiaExistir(){
		
		//When
		assertThat(evento).isNotNull();
	}

	
}
