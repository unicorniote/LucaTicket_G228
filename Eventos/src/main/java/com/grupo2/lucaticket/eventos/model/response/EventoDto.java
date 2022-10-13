package com.grupo2.lucaticket.eventos.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Clase de tipo DTO que reúne información de un evento.
 *
 * @author Álvaro Román
 * @version 1.0: 06/10/2022
 */
@Data
@Schema(name = "Evento DTO", description = "Objeto de tipo DTO de un Evento")
public class EventoDto implements Serializable {

	private static final long serialVersionUID = 1L;

    @Schema(name = "id", description = "Identificador del evento")
    private String id;
    @Schema(name = "Nombre", description = "Nombre del evento")
    private String nombre;
    @Schema(name = "Descripción", description = "Descripción del evento")
    private String descripcionEvento;
    @Schema(name = "Foto", description = "Foto del evento")
    private String foto;
    @Schema(name = "Fecha", description = "Fecha del evento")
    private LocalDate fechaEvento;
    @Schema(name = "Hora", description = "Hora del evento")
    private LocalTime horaEvento;
    @Schema(name = "Precio", description = "Renago de precios de un evento")
    private Map<String, Double> rangoPreciosEvento;
    @Schema(name = "Política de acceso", description = "Política de acceso del evento")
    private String politcaAcceso;
    @Schema(name = "Recinto", description = "Nombre del recinto del evento")
    private String recintoEvento;
    @Schema(name = "Ciudad", description = "Ciudad del recinto del evento")
    private String ciudadEvento;
    @Schema(name = "Dirección", description = "Dirección del recinto del evento")
    private String direccionEvento;
    @Schema(name = "Aforo", description = "Límite de aforo del recinto del evento")
    private Integer aforoEvento;
    @Schema(name = "Género", description = "Género del evento")
    private String genero;

}
