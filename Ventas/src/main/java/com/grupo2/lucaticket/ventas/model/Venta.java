package com.grupo2.lucaticket.ventas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Clase para representar la entidad de dats de una venta
 *
 * @author Grupo 2 - Alonso
 * @version 1.0 : 11/10/2022
 */
@Data
@Table(name = "ventas")
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Venta", description = "Entidad que representa el modelo de datos de una venta")
@Entity
public class Venta {

    @Id
    @Schema(name = "id", description = "Identificador de la venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(name = "usuario", description = "Identificador del usuario")
    private int usuario;

    @Size(max = 30)
    @Schema(name = "evento", description = "Identificador del evento")
    private String evento;
}
