package com.grupo2.lucaticket.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Grupo 2 - Lamia
 * @version 1.0 : 11/10/2022
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentasApplication.class, args);
	}

}
