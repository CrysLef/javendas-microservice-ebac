package br.com.cryslefundes.javendas.vendaservice.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProdutoDTO(
        @NotBlank
        String vendaId,
        @NotBlank
        String produtoId,
        @Positive
        Integer quantidade
) {
}
