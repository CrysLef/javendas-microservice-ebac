package br.com.cryslefundes.javendas.produtoservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("produtos")
@NoArgsConstructor
@Getter
public class Produto {
    @Id
    private String id;
    private Long codigo;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Integer estoque;

    public Produto(RegisterProdutoDTO dto) {
        this.codigo = dto.codigo();
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.valor = dto.valor();
        this.estoque = dto.estoque();
    }

    public void updateInfo(UpdateProdutoDTO dto) {
        if (dto.codigo() != null) this.codigo = dto.codigo();
        if (dto.nome() != null) this.nome = dto.nome();
        if (dto.descricao() != null) this.descricao = dto.descricao();
        if (dto.valor() != null) this.valor = dto.valor();
        if (dto.estoque() != null) this.estoque = dto.estoque();
    }
}
