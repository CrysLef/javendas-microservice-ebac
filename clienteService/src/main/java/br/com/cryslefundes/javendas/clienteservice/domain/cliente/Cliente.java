package br.com.cryslefundes.javendas.clienteservice.domain.cliente;


import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.RegisterClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.UpdateClienteDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clientes")
@NoArgsConstructor
@Getter
public class Cliente {
    @Id
    private String id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    @Embedded
    private Endereco endereco;

    public Cliente(RegisterClienteDTO dto) {
        this.cpf = dto.cpf();
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.endereco = new Endereco(dto.endereco());
    }

    public void updateInfo(UpdateClienteDTO dto) {
        if (this.cpf != null) this.cpf = dto.cpf();
        if (this.nome != null) this.nome = dto.nome();
        if (this.telefone != null) this.telefone = dto.telefone();
        if (this.email != null) this.email = dto.email();
        if (this.endereco != null) this.endereco = new Endereco(dto.endereco());
    }
}
