package com.grupo2.lucaticket.ventas.feignclients;

import com.grupo2.lucaticket.ventas.model.response.EventoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eventos", url = "http://localhost:7777")
public interface EventoFeignClient {

    @GetMapping("/eventos/detalles/{id}")
    public EventoResponseDto getEvento(@PathVariable String id);
}
