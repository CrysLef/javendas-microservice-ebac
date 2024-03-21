package br.com.cryslefundes.javendas.vendaservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder
public class ProdutoQuantidade {
    private BigDecimal valorTotal;
    private Integer quantidade;
    private Produto produto;

    public void adicionarAoCarrinho(Integer quantidade) {
        this.quantidade += quantidade;
        BigDecimal valorPorQuantidade = produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.add(valorPorQuantidade);
    }

    public void removerDoCarrinho(Integer quantidade) {
        this.quantidade -= quantidade;
        BigDecimal novoValor = produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.subtract(novoValor);
    }
}
