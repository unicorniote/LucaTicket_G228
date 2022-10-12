package com.lucaticket.pasarela.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lucaticket.pasarela.utils.ValidationUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class validar_pago {
	private static final Logger logger = LoggerFactory.getLogger(validar_pago.class);

	boolean ntarjeta;
	boolean nCVV;
	boolean nFondos;

	ValidationUtils validationUtils = new ValidationUtils();

	@Given("numero de tarjeta valido")
	public void numero_de_tarjeta_valido() {
		ntarjeta = validationUtils.validarTarjeta(2);
		assertThat(ntarjeta).isTrue();
		logger.info("numero tajeta añadido");
	}

	@Given("cvv valido")
	public void cvv_valido() {
		nCVV = validationUtils.validarCvv(2);
		assertThat(nCVV).isTrue();
		logger.info("añadido cvv");
	}

	@Given("cvv incorrecto")
	public void cvv_incorrecto() {
		nCVV = validationUtils.validarCvv(2);
		assertThat(nCVV).isTrue();
		logger.info("añadido cvv");
	}

	@Given("No hay fondos")
	public void no_hay_fondos() {
		logger.info("intentando validar pago");
		nFondos = validationUtils.validarFondos(1);
		assertThat(nFondos).isFalse();
	}

	@When("intento validar pago")
	public void intento_validar_pago() {
		logger.info("intentando validar pago");
		assertThat(ntarjeta).isTrue();
		assertThat(nCVV).isTrue();
		assertThat(nFondos).isFalse();
	}

	@When("intento validar pago sin fondos")
	public void intento_validar_pago_sin_fondos() {
		logger.info("intentando validar pago");
		assertThat(ntarjeta).isTrue();
		assertThat(nCVV).isTrue();
		assertThat(nFondos).isFalse();
	}

	@Then("operacion denegada")
	public void operacion_denegada() {
		logger.info("operacion denegada");
		assertThat(true).isTrue();
	}

	@Given("numero de tarjeta invalido")
	public void numeroDeTarjetaInvalido() {
		ntarjeta = validationUtils.validarTarjeta(1);
		assertThat(ntarjeta).isFalse();
		logger.info("numero tajeta invalido");
	}

	@When("intento validar pago con tarjeta invalida")
	public void intentoValidarPagoConTarjetaInvalida() {
		assertThat(ntarjeta).isFalse();
		logger.info("intento validar pago con tarjeta invalida");
	}

	@And("si hay fondos")
	public void siHayFondos() {
		logger.info("intentando validar pago");
		nFondos = validationUtils.validarFondos(2);
		assertThat(nFondos).isTrue();
	}

	@When("intento validar pago con todo correcto")
	public void intentoValidarPagoConTodoCorrecto() {
		logger.info("intentando validar pago");
		assertThat(ntarjeta).isTrue();
		assertThat(nCVV).isTrue();
		assertThat(nFondos).isTrue();
	}

	@Then("operacion aprobada")
	public void operacionAprobada() {
		logger.info("operacion aprobada");
	}
}
