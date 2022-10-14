package com.grupo2.lucaticket.ventas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI EventosOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("API Microservicio de Ventas")
						.description("Documentación del microservicio de Ventas").version("v1.0")
						.contact(new Contact().name("Grupo 2 - Luca Tic").url("https://grupos2-lucatic.es")
								.email("grupo2@lucatic.es"))
						.license(new License().name("LICENSE").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().description("Microservicio de Vemtas")
						.url("https://lucaticket.es"));
	}

}
