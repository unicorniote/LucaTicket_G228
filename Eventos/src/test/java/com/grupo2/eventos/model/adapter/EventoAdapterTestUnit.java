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
	EventoDto eventoDtoCompleto;
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
		eventoDtoCompleto = new EventoDto();

		// RECINTO
		recinto.setID(String.valueOf(ID_RECINTO));
		recinto.setNombreRecinto(NOMBRE_RECINTO);
		recinto.setCiudad(CIUDAD);
		recinto.setDireccion(DIRECCION);
		recinto.setTipo(TIPO);
		recinto.setAforo(String.valueOf(AFORO));

		// EVENTO
		evento.setID(ID_EVENTO);
		evento.setNombre(NOMBRE_EVENTO);
		evento.setDescripCorta(DESCRIPCION_CORTA);
		evento.setDescripExtendida(DESCRIPCION_LARGA);
		evento.setFoto(String.valueOf(FOTO));
		evento.setFechaEvento(FECHA);
		evento.setHoraEvento(HORA);
		evento.setRangoPrecio(PRECIOS);
		evento.setPoliticaAcceso(POLITICA);
		evento.setRecinto(recinto);
		evento.setGenero(GENERO);

		eventos.add(evento);
		eventos.add(evento);

		//EventoDTO
		
		
		eventoDtoCompleto.setId(ID_EVENTO);
		eventoDtoCompleto.setNombreEvento(CIUDAD);
		eventoDtoCompleto.setDescripcionEvento(DESCRIPCION_CORTA);
		eventoDtoCompleto.setFoto(FOTO);
		eventoDtoCompleto.setFechaEvento(FECHA);
		eventoDtoCompleto.setHoraEvento(HORA);
		eventoDtoCompleto.setRangoPreciosEvento(PRECIOS);
		eventoDtoCompleto.setPolitcaAcceso(POLITICA);
		eventoDtoCompleto.setNombreEvento(CIUDAD);
		eventoDtoCompleto.setCiudadEvento(CIUDAD);
		eventoDtoCompleto.setDireccionEvento(DIRECCION);
		eventoDtoCompleto.setAforoEvento(AFORO);
		eventoDtoCompleto.setGenero(GENERO);
		
	}

	@Test
	void testSetUp() {

		assertThat(evento).isNotNull();
		assertThat(eventos).isNotNull();

	}

	@Test
	void shouldReturnsEventoDtoNotNull() {

		assertThat(eventoAdapter.eventoToDto(evento)).isNotNull();
	}

	@Test
	void shouldReturnsEventoDtoComplete() {

		
		assertThat(eventoAdapter.eventoToDto(evento)).isEqualTo(eventoDtoCompleto);
	}

	@Test
	void shouldReturnEventoDtoListNotNull() {

		assertThat(eventoAdapter.eventoToDto(eventos)).isNotNull();
	}

	@Test
	void shouldReturnsEventoDtoList() {
		
		List<EventoDto> eventosDto = new ArrayList<>();
		eventosDto.add(eventoDtoCompleto);
		eventosDto.add(eventoDtoCompleto);

		assertThat(eventoAdapter.eventoToDto(eventos)).isEqualTo(eventosDto);
	}

}
