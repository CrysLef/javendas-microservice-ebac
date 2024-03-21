package br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto;

import br.com.cryslefundes.javendas.clienteservice.domain.cliente.Cliente;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ClienteDTO (
        @NotBlank
        String id,
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
        Endereco endereco

) {
    public ClienteDTO(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getEndereco()
        );
    }
}
