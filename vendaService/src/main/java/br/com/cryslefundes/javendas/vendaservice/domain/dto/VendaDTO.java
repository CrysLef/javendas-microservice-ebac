package br.com.cryslefundes.javendas.vendaservice.domain.dto;

import br.com.cryslefundes.javendas.vendaservice.domain.ProdutoQuantidade;
import br.com.cryslefundes.javendas.vendaservice.domain.StatusVenda;
import br.com.cryslefundes.javendas.vendaservice.domain.Venda;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

public record VendaDTO(
        @NotBlank
        String id,
        @NotNull
        Long codigo,
        @NotNull
        StatusVenda statusVenda,
        @NotNull
        Instant dataVenda,
        @NotNull
        BigDecimal valorTotal,
        @NotBlank
        String clienteId,
        Set<ProdutoQuantidade> produtos
) {
    public VendaDTO(Venda venda) {
        this(
                venda.getId(),
                venda.getCodigo(),
                venda.getStatusVenda(),
                venda.getDataVenda(),
                venda.getValorTotal(),
                venda.getClienteId(),
                venda.getProdutos()
        );
    }
}
