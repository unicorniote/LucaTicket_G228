package com.grupo2.lucaticket.usuario.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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
@AllArgsConstructor
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
    private String nombre;

    @Size(max = 100)
    @Schema(name = "apellido", description = "Apellidos del usuario")
    private String apellido;

    @Size(max = 150)
    @Schema(name = "email", description = "Direccion de correo electronico del usuario")
    private String email;

    @Size(max = 20)
    @NotNull
    @Schema(name = "pass", description = "Contraseña del usuario")
    private String pass;

    @Schema(name = "fechaAlta", description = "Fecha de cuando el usuario se registro en el sistema del usuario")
    private LocalDate fechaAlta;

}
