package com.grupo2.eventos.model.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.grupo2.eventos.model.Evento;

@ExtendWith(MockitoExtension.class)
public class EventoDTOTestUnit {

	// Given
	@InjectMocks
	EventoDto evento;

	// Valores por defecto
	private final int ID = 1;
	private final String NOMBRE_EVENTO = "Evento de prueba";
	private final String DESCRIPCION_EVENTO = "Descripción del evento";
	private final boolean FOTO = true;
	private final LocalDate FECHA = LocalDate.parse("2022-10-06");
	private final LocalTime HORA = LocalTime.parse("22:01:50");
	private final Map<String, Double> PRECIOS = Map.of("General", 50.0, "VIP", 100.0);
	private final String POLITICA = "No se adminten menores";
	private final String NOMBRE_RECINTO = "Nombre del recinto";
	private final String CIUDAD = "Madrid";
	private final String DIRECCION = "LUCATIC";
	private final int AFORO = 100;
	private final String GENERO = "Genero del evento";
	
	void setUp() {
	//EventoDTO
	evento=new EventoDto();
	evento.setId(ID);
	evento.setNombreEvento(NOMBRE_EVENTO);
	evento.setDescripcionEvento(DESCRIPCION_EVENTO);
	evento.setFoto(FOTO);
	evento.setFechaEvento(FECHA);
	evento.setHoraEvento(HORA);
	evento.setRangoPreciosEvento(PRECIOS);
	evento.setPolitcaAcceso(POLITICA);
	evento.setCiudadEvento(CIUDAD);
	evento.setDireccionEvento(DIRECCION);
	evento.setAforoEvento(AFORO);
	evento.setGenero(GENERO);

	}
	@Test
	void eventDtoExists() {

		assertThat(evento).isNotNull();
	}

	@Test
	void eventDtoShouldHaveId() {

		// When
		evento.setId(ID);

		// Then
		assertThat(evento.getId()).isEqualTo(ID);

	}

	@Test
	void eventDtoShouldHaveNombreEvento() {

		// When
		evento.setNombreEvento(NOMBRE_EVENTO);

		// Then
		assertThat(evento.getNombreEvento()).isEqualTo(NOMBRE_EVENTO);

	}

	@Test
	void eventDtoShouldHaveFoto() {

		// When
		evento.setFoto(FOTO);

		// Then
		assertThat(evento.isFoto()).isEqualTo(FOTO);

	}

	@Test
	void eventDtoShouldHaveFecha() {

		// When
		evento.setFechaEvento(FECHA);

		// Then
		assertThat(evento.getFechaEvento()).isEqualTo(FECHA);

	}

	@Test
	void eventDtoShouldHaveHora() {

		// When
		evento.setHoraEvento(HORA);

		// Then
		assertThat(evento.getHoraEvento()).isEqualTo(HORA);

	}

	@Test
	void eventDtoShouldHavePrecios() {

		// When
		evento.setRangoPreciosEvento(PRECIOS);

		// Then
		assertThat(evento.getRangoPreciosEvento()).isEqualTo(PRECIOS);

	}

	@Test
	void eventDtoShouldHavePolitica() {

		// When
		evento.setPolitcaAcceso(POLITICA);

		// Then
		assertThat(evento.getPolitcaAcceso()).isEqualTo(POLITICA);

	}

	@Test
	void eventDtoShouldHaveNombreRecinto() {

		// When
		evento.setRecintoEvento(NOMBRE_RECINTO);

		// Then
		assertThat(evento.getRecintoEvento()).isEqualTo(NOMBRE_RECINTO);

	}

	@Test
	void eventDtoShouldHaveCiudad() {

		// When
		evento.setCiudadEvento(CIUDAD);

		// Then
		assertThat(evento.getCiudadEvento()).isEqualTo(CIUDAD);

	}

	@Test
	void eventDtoShouldHaveDireccion() {

		// When
		evento.setDireccionEvento(DIRECCION);

		// Then
		assertThat(evento.getDireccionEvento()).isEqualTo(DIRECCION);

	}

	@Test
	void eventDtoShouldHaveAforo() {

		// When
		evento.setAforoEvento(AFORO);

		// Then
		assertThat(evento.getAforoEvento()).isEqualTo(AFORO);

	}

	@Test
	void eventDtoShouldHaveGenero() {

		// When
		evento.setGenero(GENERO);

		// Then
		assertThat(evento.getGenero()).isEqualTo(GENERO);

	}

	void eventDtoShouldBeCreated() {

		
		
		// Then
		assertThat(evento).isNotNull();

	}

}
