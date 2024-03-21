package br.com.cryslefundes.javendas.vendaservice.domain;

import br.com.cryslefundes.javendas.vendaservice.domain.exception.EstoqueException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private String id;

    private Long codigo;

    private String nome;

    private String descricao;

    private BigDecimal valor;
    private Integer estoque;

    public Produto(Long codigo, String nome, String descricao, BigDecimal valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = 0;
    }

    public void adicionaAoEstoque(Integer quantidade) {
        this.estoque += quantidade;
    }
    public void removeDoEstoque(Integer quantidade) {
        if ((this.estoque -= quantidade) < 0)
            throw new EstoqueException("Não é possível remover mais quantidades deste produto, seu estoque é de: " + this.estoque);

        this.estoque -= quantidade;
    }
}
