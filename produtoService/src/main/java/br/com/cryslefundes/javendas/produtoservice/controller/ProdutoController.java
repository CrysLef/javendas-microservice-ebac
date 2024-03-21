package br.com.cryslefundes.javendas.produtoservice.controller;

import br.com.cryslefundes.javendas.produtoservice.domain.ProdutoDTO;
import br.com.cryslefundes.javendas.produtoservice.domain.RegisterProdutoDTO;
import br.com.cryslefundes.javendas.produtoservice.domain.UpdateProdutoDTO;
import br.com.cryslefundes.javendas.produtoservice.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> getAllProdutos(@ParameterObject @PageableDefault(sort = "nome") Pageable pagination) {
        return ResponseEntity.ok(service.getAllProdutos(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProduto(@PathVariable String id) {
        return ResponseEntity.ok(service.getProduto(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDTO> registerProduto(@RequestBody @Valid RegisterProdutoDTO dto) {
        return ResponseEntity.ok(service.registerProduto(dto));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ProdutoDTO> updateProduto(@RequestBody @Valid UpdateProdutoDTO dto) {
        return ResponseEntity.ok(service.updateProduto(dto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removeProduto(@PathVariable String id) {
        service.removeProduto(id);
        return ResponseEntity.noContent().build();
    }
}
