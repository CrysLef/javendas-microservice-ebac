package br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterClienteDTO (
        @NotNull
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}", message = "CPF com formato inválido, tente algo assim: 000.000.000-00")
        String cpf,
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}")
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotNull
        @Valid
        EnderecoDTO endereco
) {
}
