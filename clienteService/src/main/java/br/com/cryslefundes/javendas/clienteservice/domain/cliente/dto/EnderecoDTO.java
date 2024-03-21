package br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
    @NotBlank
    String endereco,
    @NotNull
    Integer numero,
    String complemento,
    @NotBlank
    String estado,
    @NotBlank
    String cidade,
    @NotBlank
    @Pattern(regexp = "\\d{5,10}")
    @JsonAlias("zip_code")
    String cep
) {
}
