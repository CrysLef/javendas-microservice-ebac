package br.com.cryslefundes.javendas.vendaservice.service.validation;

import br.com.cryslefundes.javendas.vendaservice.domain.dto.ProdutoDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.exception.EstoqueException;
import br.com.cryslefundes.javendas.vendaservice.repository.VendaRepository;
import br.com.cryslefundes.javendas.vendaservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaQuantidadeMaiorQueEstoque implements Validation<ProdutoDTO> {
    private final VendaRepository repository;
    private final ProdutoService produtoService;

    @Autowired
    public ValidaQuantidadeMaiorQueEstoque(VendaRepository repository, ProdutoService produtoService) {
        this.repository = repository;
        this.produtoService = produtoService;
    }

    @Override
    public void valida(ProdutoDTO dto) {
        var venda = repository.findById(dto.vendaId());

        if (venda.isPresent()) {
            var produto = produtoService.buscaProduto(dto.produtoId());
            if (produto != null) {
                if (produto.getEstoque() < dto.quantidade()) {
                    throw new EstoqueException("Não é possível adicionar ou remover esta quantidade deste produto, seu estoque é de: " + produto.getEstoque());
                }
            }
        }
    }
}
