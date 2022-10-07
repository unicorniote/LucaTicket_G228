package com.grupo2.eventos.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecintoTest {

	//Given
		@Mock
		private Recinto recinto;
		
		@Test
		void recintoDeberiaExistir(){
			
			//When
			assertThat(recinto).isNotNull();
		}
	
	
}
