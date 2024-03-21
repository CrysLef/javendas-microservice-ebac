package br.com.cryslefundes.javendas.vendaservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Document("vendas")
@NoArgsConstructor
@Getter
public class Venda {
    @Id
    private String id;
    @Indexed(unique = true, background = true)
    private Long codigo;
    private StatusVenda statusVenda;
    private Instant dataVenda;
    private BigDecimal valorTotal;
    private String clienteId;
    private Set<ProdutoQuantidade> produtos;

    public Venda(Long codigo, String clienteId) {
        this.codigo = codigo;
        this.clienteId = clienteId;
        this.statusVenda = StatusVenda.INICIADA;
        this.dataVenda = Instant.now();
        this.valorTotal = BigDecimal.ZERO;
        this.produtos = new HashSet<>();
    }

    public void finalizaVenda() {
        this.statusVenda = StatusVenda.CONCLUIDA;
        produtos.forEach(pq -> pq.getProduto().removeDoEstoque(pq.getQuantidade()));
    }

    public void cancelaVenda() {
        if (this.statusVenda == StatusVenda.CONCLUIDA) produtos.forEach(pq -> pq.getProduto().adicionaAoEstoque(pq.getQuantidade()));
        this.statusVenda = StatusVenda.CANCELADA;
    }

    public void removerProduto(ProdutoQuantidade produto, Integer quantidade) {
        if (produtos.contains(produto)) {
            if (produto.getQuantidade() > quantidade) {
                produto.removerDoCarrinho(quantidade);
            } else {
                produtos.remove(produto);
            }
            recalculaValorTotal();
        }
    }

    public void adicionarProduto(ProdutoQuantidade produtoQtd, Integer quantidade) {
        if (!produtos.contains(produtoQtd)) {
            produtoQtd.adicionarAoCarrinho(quantidade);
            produtos.add(produtoQtd);
        } else {
            produtoQtd.adicionarAoCarrinho(quantidade);
        }
        recalculaValorTotal();
    }

    public void removerTodosProdutos() {
        produtos.clear();
        recalculaValorTotal();
    }

    public void recalculaValorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ProdutoQuantidade p: produtos) {
            valorTotal = valorTotal.add(p.getValorTotal());
        }
        this.valorTotal = valorTotal;
    }

    public void atualizaVenda(Long codigo, String clienteId) {
        if (codigo != null) this.codigo = codigo;
        if (clienteId != null) this.clienteId = clienteId;
    }
}
