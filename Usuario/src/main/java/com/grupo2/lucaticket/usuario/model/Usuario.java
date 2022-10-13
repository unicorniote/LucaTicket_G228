package com.grupo2.lucaticket.usuario.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project LucaTicket
 *
 * @Classname Usuario
 *
 * @Author Grupo 2 - Alonso
 *
 * @Date 06/10/2022
 */
@Data
@Table(name = "usuario")
@NoArgsConstructor
@Schema(name = "Usuario", description = "Entidad que representa el modelo de datos de un usuario")
@Entity
public class Usuario {

	@Id
	@Schema(name = "id", description = "Identificador numerico del usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(max = 100)
	@Schema(name = "nombre", description = "Nombre del usuario")
	@NotEmpty
	private String nombre;

	@Size(max = 100)
	@Schema(name = "apellido", description = "Apellidos del usuario")
	@NotEmpty
	private String apellido;

	@Size(max = 150)
	@Schema(name = "email", description = "Direccion de correo electronico del usuario")
	@Pattern(regexp = "^(.+)@(.+)$", message = "El email debe tener el siguiente formato: email@servidor.com")
	private String email;

	@Size(max = 20)
	@NotEmpty
	@Schema(name = "pass", description = "Contraseña del usuario")
	private String pass;

	@Schema(name = "fechaAlta", description = "Fecha de cuando el usuario se registró en el sistema del usuario")
	private LocalDate fechaalta = LocalDate.now();

	public Usuario(String nombre, String apellido, String pass) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.pass = pass;

	}

}
