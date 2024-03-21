package br.com.cryslefundes.javendas.produtoservice.repository;

import br.com.cryslefundes.javendas.produtoservice.domain.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
}
