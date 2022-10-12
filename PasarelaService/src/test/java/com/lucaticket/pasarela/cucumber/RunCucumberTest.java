package com.lucaticket.pasarela.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, features = { "classpath:features/validar_pago.feature" }, glue = {
		"com.lucaticket.pasarela.cucumber.steps" })
public class RunCucumberTest {

}
