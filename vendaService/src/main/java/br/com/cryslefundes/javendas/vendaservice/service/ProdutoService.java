package br.com.cryslefundes.javendas.vendaservice.service;

import br.com.cryslefundes.javendas.vendaservice.adapter.ProdutoGateway;
import br.com.cryslefundes.javendas.vendaservice.domain.Produto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoGateway gateway;

    @Autowired
    public ProdutoService(ProdutoGateway gateway) {
        this.gateway = gateway;
    }

    public Produto buscaProduto(String produtoId) {
        var produto = gateway.buscaProdutoPorId(produtoId);
        if (produto == null) throw new EntityNotFoundException("Produto não encontrado.");
        return produto;
    }
}
