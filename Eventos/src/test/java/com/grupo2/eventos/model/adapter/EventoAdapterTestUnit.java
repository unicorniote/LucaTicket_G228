package com.grupo2.eventos.model.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.grupo2.eventos.model.Evento;
import com.grupo2.eventos.model.Recinto;
import com.grupo2.eventos.model.response.EventoDto;

@ExtendWith(MockitoExtension.class)
public class EventoAdapterTestUnit {

//	EventoAdapter eventoAdapter = new EventoAdapter();
	@InjectMocks
	EventoAdapter eventoAdapter;

//	@InjectMocks
//	EventoDto eventoDto;

	Evento evento;
	Recinto recinto;
	List<Evento> eventos = new ArrayList<>();

	private final int ID_EVENTO = 1;
	private final int ID_RECINTO = 1;
	private final String NOMBRE_EVENTO = "Evento de prueba";
	private final String DESCRIPCION_CORTA = "Descripción corta del evento";
	private final String DESCRIPCION_LARGA = "Descripción larga del evento";
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
	private final String TIPO = "Tipo del recinto";

	@BeforeEach
	void setUp() {
		evento = new Evento();
		recinto = new Recinto();

		// RECINTO
		recinto.setID(ID_RECINTO);
		recinto.setNomRecinto(NOMBRE_RECINTO);
		recinto.setCiudad(CIUDAD);
		recinto.setDireccion(DIRECCION);
		recinto.setTipo(TIPO);
		recinto.setAforo(AFORO);

		// EVENTO
		evento.setID(ID_EVENTO);
		evento.setNombre(NOMBRE_EVENTO);
		evento.setDescripCorta(DESCRIPCION_CORTA);
		evento.setDescripExtendida(DESCRIPCION_LARGA);
		evento.setFoto(FOTO);
		evento.setFechaEvento(FECHA);
		evento.setHoraEvento(HORA);
		evento.setRangoPrecio(PRECIOS);
		evento.setPoliticaAcceso(POLITICA);
		evento.setRecinto(recinto);
		evento.setGenero(GENERO);

		eventos.add(evento);
		eventos.add(evento);

	}

	@Test
	void testSetUp() {

		assertThat(evento).isNotNull();
		assertThat(eventos).isNotNull();

	}

	@Test
	void shouldReturnsEventoDtoNotNull() {

		assertThat(eventoAdapter.EventoToDto(evento)).isNotNull();
	}

	@Test
	void shouldReturnsEventoDtoComplete() {

		EventoDto eventoDtoCompleto = new EventoDto(ID_EVENTO, NOMBRE_EVENTO, DESCRIPCION_CORTA, FOTO, FECHA, HORA,
				PRECIOS, POLITICA, NOMBRE_RECINTO, CIUDAD, DIRECCION, AFORO, GENERO);

		assertThat(eventoAdapter.EventoToDto(evento)).isEqualTo(eventoDtoCompleto);
	}

	@Test
	void shouldReturnEventoDtoListNotNull() {

		assertThat(eventoAdapter.EventoToDto(eventos)).isNotNull();
	}

	@Test
	void shouldReturnsEventoDtoList() {

		EventoDto eventoDtoCompleto = new EventoDto(ID_EVENTO, NOMBRE_EVENTO, DESCRIPCION_CORTA, FOTO, FECHA, HORA,
				PRECIOS, POLITICA, NOMBRE_RECINTO, CIUDAD, DIRECCION, AFORO, GENERO);
		List<EventoDto> eventosDto = new ArrayList<>();
		eventosDto.add(eventoDtoCompleto);
		eventosDto.add(eventoDtoCompleto);

		assertThat(eventoAdapter.EventoToDto(eventos)).isEqualTo(eventosDto);
	}

}
