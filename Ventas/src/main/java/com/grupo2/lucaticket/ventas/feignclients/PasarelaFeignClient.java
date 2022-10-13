package com.grupo2.lucaticket.ventas.feignclients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "pasarela", url = "http://localhost:10000")
public interface PasarelaFeignClient {

}
