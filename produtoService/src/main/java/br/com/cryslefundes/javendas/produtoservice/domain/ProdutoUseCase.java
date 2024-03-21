package br.com.cryslefundes.javendas.produtoservice.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoUseCase {
    Page<ProdutoDTO> getAllProdutos(Pageable pagination);
    ProdutoDTO getProduto(String id);
    ProdutoDTO registerProduto(RegisterProdutoDTO dto);
    ProdutoDTO updateProduto(UpdateProdutoDTO dto);
    void removeProduto(String id);
}
