package com.lucaticket.pasarela.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucaticket.pasarela.controller.ValidarPagosController;
import com.lucaticket.pasarela.model.Tarjeta;
import com.lucaticket.pasarela.service.ValidarPagosService;
import com.lucaticket.pasarela.utils.ValidationUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;

@CucumberContextConfiguration
@WebMvcTest(ValidarPagosController.class)
@Slf4j
public class validar_pago {

	@Autowired
	private MockMvc mockMvc;

//	@MockBean
//	private ValidarPagosRepositoryI validarRepository;

	@InjectMocks
	private ValidarPagosController validarController;

	@Autowired
	@MockBean
	private ValidarPagosService validarService;

	private MvcResult respuesta;

	@InjectMocks
	ValidationUtils validationUtils;

	// CASOS TARJETA
	@Given("numero tarjeta valido")
	public void numero_tarjeta_valido() {
		log.info("Dado que el número de tarjeta es válido...");
		when(validarService.encontrarTarjeta()).thenReturn(2);
	}

	@Given("numero tarjeta no valido")
	public void numero_tarjeta_no_valido() {
		log.info("Dado que el número de tarjeta no es válido...");
		when(validarService.encontrarTarjeta()).thenReturn(1);
	}

	// CASOS CVV
	@Given("cvv valido")
	public void cvv_valido() {
		log.info("Dado que el CVV es válido...");
		when(validarService.validarCvv()).thenReturn(2);
	}

	@Given("cvv incorrecto")
	public void cvv_incorrecto() {
		log.info("Dado que el CVV no es válido...");
		when(validarService.validarCvv()).thenReturn(1);
	}

	// CASOS FONDOS
	@Given("sin fondos")
	public void sin_fondos() {
		log.info("Dado que no hay fondos sucientes...");
		when(validarService.consultarFondos()).thenReturn(1);
	}

	@Given("fondos suficientes")
	public void fondos_suficientes() {
		log.info("Dado que hay fondos sucientes...");
		when(validarService.consultarFondos()).thenReturn(2);
	}

	// LLAMADA A MÉTODO VALIDAR
	@When("intento validar pago")
	public void intento_validar_pago() throws Exception {
		log.info("Intentando validar el pago...");
		respuesta = mockMvc.perform(post("http://localhost:8080/pasarela/pagar")
				.content(new ObjectMapper().writeValueAsString(new Tarjeta("123456789", "123")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
	}

	// RESULTADOS
	@Then("operacion denegada no hay fondos")
	public void operacion_denegada_no_hay_fondos() throws Exception {
		log.info("La operación es denegada por falta de fondos...");
		assertThat(respuesta.getResponse().getStatus()).isEqualTo(207);
	}

	@Then("operacion denegada cvv incorrecto")
	public void operacion_denegada_cvv_incorrecto() throws Exception {
		log.info("La operación es denegada por CVV incorrecto...");
		assertThat(respuesta.getResponse().getStatus()).isEqualTo(203);
	}

	@Then("operacion denegada numero tarjeta no valido")
	public void operacion_denegada_numero_tarjeta_no_valido() throws Exception {
		log.info("La operación es denegada por número de tarjeta incorrecto...");
		assertThat(respuesta.getResponse().getStatus()).isEqualTo(404);
	}

	@Then("operacion aprobada")
	public void operacion_aprobada() throws Exception {
		log.info("La operación es aprobada...");
		assertThat(respuesta.getResponse().getStatus()).isEqualTo(202);
	}
}
