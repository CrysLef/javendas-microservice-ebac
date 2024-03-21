package br.com.cryslefundes.javendas.vendaservice.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegistraVendaDTO(
        @NotBlank
        String clienteId,
        @NotNull
        Long codigo
) {
}
