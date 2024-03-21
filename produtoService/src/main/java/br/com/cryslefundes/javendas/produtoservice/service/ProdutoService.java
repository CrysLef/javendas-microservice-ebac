package br.com.cryslefundes.javendas.produtoservice.service;

import br.com.cryslefundes.javendas.produtoservice.domain.*;
import br.com.cryslefundes.javendas.produtoservice.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService implements ProdutoUseCase {
    private final ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }


    @Override
    public Page<ProdutoDTO> getAllProdutos(Pageable pagination) {
        return repository.findAll(pagination).map(ProdutoDTO::new);
    }

    @Override
    public ProdutoDTO getProduto(String id) {
        Optional<Produto> maybeProduto = repository.findById(id);
        if (maybeProduto.isEmpty()) throw new EntityNotFoundException("Produto não encontrado.");
        var produto = maybeProduto.get();
        return new ProdutoDTO(produto);
    }

    @Override
    public ProdutoDTO registerProduto(RegisterProdutoDTO dto) {
        var produto = new Produto(dto);
        repository.save(produto);
        return new ProdutoDTO(produto);
    }

    @Override
    public ProdutoDTO updateProduto(UpdateProdutoDTO dto) {
        Optional<Produto> maybeProduto = repository.findById(dto.id());
        if (maybeProduto.isEmpty()) throw new EntityNotFoundException("Produto não encontrado.");
        var produto = maybeProduto.get();
        produto.updateInfo(dto);
        return new ProdutoDTO(produto);
    }

    @Override
    public void removeProduto(String id) {
        repository.deleteById(id);
    }
}
