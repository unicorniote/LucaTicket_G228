package com.lucaticket.pasarela.feignclients;

import com.lucaticket.pasarela.model.Tarjeta;
import com.lucaticket.pasarela.model.response.VentasDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pasarela", url = "http://localhost:10000")
public interface PasarelaFeignClient {

    @PostMapping("/pasarela/pagar")
    public ResponseEntity<?> checkCompra(@RequestBody Tarjeta tarjeta);
}
