package com.grupo2.lucaticket.ventas.feignclients;

import com.grupo2.lucaticket.ventas.model.response.VentasDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pasarela", url = "http://localhost:10000")
public interface PasarelaFeignClient {

    @PostMapping("/pasarela/info")
    public ResponseEntity<?> checkCompra(@RequestBody VentasDto ventasDto);
}
