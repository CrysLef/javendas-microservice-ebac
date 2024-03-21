package br.com.cryslefundes.javendas.clienteservice.domain.cliente;

import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.EnderecoDTO;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Endereco {
    private String endereco;
    private int numero;
    private String complemento;
    private String estado;
    private String cidade;
    private String cep;

    public Endereco(EnderecoDTO dto) {
        this.endereco = dto.endereco();
        this.numero = dto.numero();
        this.complemento = dto.complemento();
        this.estado = dto.estado();
        this.cidade = dto.cidade();
        this.cep = dto.cep();
    }
}
