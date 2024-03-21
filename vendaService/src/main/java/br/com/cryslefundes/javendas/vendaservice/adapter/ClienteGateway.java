package br.com.cryslefundes.javendas.vendaservice.adapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cliente", url = "${application.service.cliente.endpoint}")
public interface ClienteGateway {
    @RequestMapping(method = RequestMethod.GET, value = "/{id}/is-cadastrado")
    Boolean buscaClienteId(@RequestParam("id") String id);
}
