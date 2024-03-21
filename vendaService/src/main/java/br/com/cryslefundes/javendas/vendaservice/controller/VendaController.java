package br.com.cryslefundes.javendas.vendaservice.controller;

import br.com.cryslefundes.javendas.vendaservice.domain.dto.AtualizaVendaDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.ProdutoDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.RegistraVendaDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.VendaDTO;
import br.com.cryslefundes.javendas.vendaservice.service.VendaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    private final VendaService service;

    @Autowired
    public VendaController(VendaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Page<VendaDTO>> buscaTodasAsVendas(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(service.buscaTodasAsVendas(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDTO> buscaVenda(@PathVariable String id) {
        return ResponseEntity.ok(service.buscaVenda(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VendaDTO> iniciaVenda(@RequestBody @Valid RegistraVendaDTO dto) {
        return ResponseEntity.ok(service.iniciaVenda(dto));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<VendaDTO> atualizaVenda(@RequestBody @Valid AtualizaVendaDTO dto) {
        return ResponseEntity.ok(service.atualizaVenda(dto));
    }

    @PutMapping("/{id}/finalizar")
    @Transactional
    public ResponseEntity<String> finalizaVenda(@PathVariable String id) {
        service.finalizaVenda(id);
        return ResponseEntity.ok("Venda finaliza com sucesso!");
    }

    @PutMapping("/{id}/cancelar")
    @Transactional
    public ResponseEntity<String> cancelaVenda(@PathVariable String id) {
        service.cancelaVenda(id);
        return ResponseEntity.ok("Venda cancelada com sucesso!");
    }

    @PutMapping("/remover-produto")
    @Transactional
    public ResponseEntity<String> removerProdutoDaVenda(@RequestBody @Valid ProdutoDTO dto) {
        service.removeProdutoDaVenda(dto);
        return ResponseEntity.ok("Produto removido com sucesso!");
    }

    @PutMapping("/{id}/remover-produtos")
    @Transactional
    public ResponseEntity<String> removerTodosOsProdutoDaVenda(@PathVariable String id) {
        service.removeTodosProdutos(id);
        return ResponseEntity.ok("Todos os produtos foram removidos com sucesso!");
    }

    @PutMapping("/adicionar-produto")
    @Transactional
    public ResponseEntity<String> adicionarProdutoAVenda(@RequestBody @Valid ProdutoDTO dto) {
        service.adicionaProdutoAVenda(dto);
        return ResponseEntity.ok("Produto adicionado com sucesso!");
    }

}
