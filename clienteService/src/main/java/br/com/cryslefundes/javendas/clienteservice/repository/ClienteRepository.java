package br.com.cryslefundes.javendas.clienteservice.repository;

import br.com.cryslefundes.javendas.clienteservice.domain.cliente.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
