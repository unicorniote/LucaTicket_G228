package com.lucaticket.pasarela.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@Schema(name = "InfoCompraDto", description = "Informacion de la compra")
@Data
public class InfoCompraDto implements Serializable {

    @Schema(name = "usuario", description = "El nombre completo del usuario que va a realizar el pago")
    private String usuario;

    @Schema(name = "evento", description = "Nombre de la actuacion")
    private String evento;

    @Schema(name = "recinto", description = "Nombre del recinto donde se va a celebrar la actuacion")
    private String recinto;

    @Schema(name = "precio", description = "Precio de la entrada")
    private Map<String, Double> precio;

    @Schema(name = "fecha", description = "Fecha de cuando se va a llevar a cabo la actuacion")
    private LocalDate fecha;

}
