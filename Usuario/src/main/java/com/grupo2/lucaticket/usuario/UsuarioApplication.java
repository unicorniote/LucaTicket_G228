package com.grupo2.lucaticket.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* @Project LucaTicket
*
* @Classname UsuarioNotFoundException
*
* @author Alonso
* @date 07/10/2022
*
* @since 1.0
*
*/
@SpringBootApplication
@EnableDiscoveryClient
public class UsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

}
