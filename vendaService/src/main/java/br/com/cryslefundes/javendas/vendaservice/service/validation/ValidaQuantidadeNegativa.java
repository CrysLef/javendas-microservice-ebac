package br.com.cryslefundes.javendas.vendaservice.service.validation;

import br.com.cryslefundes.javendas.vendaservice.domain.dto.ProdutoDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.exception.QuantidadeException;
import org.springframework.stereotype.Component;

@Component
public class ValidaQuantidadeNegativa implements Validation<ProdutoDTO> {

    @Override
    public void valida(ProdutoDTO dto) {
        if (dto.quantidade() < 0) {
            throw new QuantidadeException("A quantidade que deseja adicionar ou remover do carrinho é negativa.");
        }
    }
}
