package com.grupo2.lucaticket.usuario.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Schema(name = "UsuarioCompletoDto", description = "DTO de Usuario")
public class UsuarioCompletoDto extends UsuarioDto implements Serializable {

    @Schema(name = "email", description = "Direccion de correo electronico del usuario")
    private String email;

    @Schema(name = "pass", description = "Contraseña del usuario")
    private String pass;

    @Schema(name = "fechaAlta", description = "Fecha de cuando el usuario se registro en el sistema del usuario")
    private LocalDate fechaalta;
}
