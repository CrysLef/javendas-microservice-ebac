package br.com.cryslefundes.javendas.vendaservice.repository;

import br.com.cryslefundes.javendas.vendaservice.domain.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendaRepository extends MongoRepository<Venda, String> {
}
