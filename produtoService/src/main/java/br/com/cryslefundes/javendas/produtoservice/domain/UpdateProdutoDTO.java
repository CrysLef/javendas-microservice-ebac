package br.com.cryslefundes.javendas.produtoservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record UpdateProdutoDTO(
        @NotBlank
        String id,
        Long codigo,
        String nome,
        String descricao,
        BigDecimal valor,
        @PositiveOrZero
        Integer estoque
) {
}
