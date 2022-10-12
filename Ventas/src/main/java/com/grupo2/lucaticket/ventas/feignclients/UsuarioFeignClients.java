package com.grupo2.lucaticket.ventas.feignclients;
import com.grupo2.lucaticket.ventas.model.response.UsuarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario", url = "http://localhost:8888")
public interface UsuarioFeignClients {

    @GetMapping("/usuario/{id}?simple=true")
    public UsuarioDto getUsuario(@PathVariable int id);
}
