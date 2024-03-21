package br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UpdateClienteDTO (
        @NotBlank
        String id,
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}", message = "CPF com formato inválido, tente algo assim: 000.000.000-00")
        String cpf,
        String nome,
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}")
        String telefone,
        @Email
        String email,
        EnderecoDTO endereco
) {
}
