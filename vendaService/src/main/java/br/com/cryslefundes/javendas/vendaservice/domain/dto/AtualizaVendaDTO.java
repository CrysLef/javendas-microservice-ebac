package br.com.cryslefundes.javendas.vendaservice.domain.dto;

import br.com.cryslefundes.javendas.vendaservice.domain.StatusVenda;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizaVendaDTO(
        @NotBlank
        String id,
        StatusVenda statusVenda,
        String clienteId,
        Long codigo
) {
}
