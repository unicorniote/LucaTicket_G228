package com.grupo2.lucaticket.usuario.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.grupo2.lucaticket.usuario.model.Usuario;

@Data
@Schema(name = "UsuarioDto", description = "DTO de Usuario")
public class UsuarioDto implements Serializable {

    @Schema(name = "id", description = "Identificador numerico del usuario")
    private String id;

    @Schema(name = "nombre", description = "Nombre del usuario")
    private String nombre;

    @Schema(name = "apellido", description = "Apellidos del usuario")
    private String apellido;

    @Schema(name = "email", description = "Direccion de correo electronico del usuario")
    private String email;

    @Schema(name = "pass", description = "Contraseña del usuario")
    private String pass;

    @Schema(name = "fechaAlta", description = "Fecha de cuando el usuario se registro en el sistema del usuario")
    private LocalDate fechaalta;



	
	}



    
    


