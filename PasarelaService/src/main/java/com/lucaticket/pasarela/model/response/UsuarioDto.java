package com.lucaticket.pasarela.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Alonso
 * @Project LucaTicket
 * @Classname UsuarioDto
 * @date 09/10/2022
 * @since 1.0
 */
@Data
@Schema(name = "UsuarioDto", description = "DTO de Usuario")
public class UsuarioDto implements Serializable {

    @Schema(name = "id", description = "Identificador numerico del usuario")
    private int id;

    @Schema(name = "nombre", description = "Nombre del usuario")
    private String nombre;

    @Schema(name = "apellido", description = "Apellidos del usuario")
    private String apellido;
}
