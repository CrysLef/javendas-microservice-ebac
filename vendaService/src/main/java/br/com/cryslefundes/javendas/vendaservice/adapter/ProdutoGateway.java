package br.com.cryslefundes.javendas.vendaservice.adapter;

import br.com.cryslefundes.javendas.vendaservice.domain.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "produto", url = "${application.service.produto.endpoint}")
public interface ProdutoGateway {
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Produto buscaProdutoPorId(@RequestParam("id") String id);
}
