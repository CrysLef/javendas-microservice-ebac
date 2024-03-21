package br.com.cryslefundes.javendas.produtoservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProdutoDTO(
        @NotBlank
        String id,
        @NotNull
        Long codigo,
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        BigDecimal valor,
        @NotNull
        @PositiveOrZero
        Integer estoque
) {
    public ProdutoDTO(Produto produto) {
        this(
                produto.getId(),
                produto.getCodigo(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getEstoque()
        );
    }
}
