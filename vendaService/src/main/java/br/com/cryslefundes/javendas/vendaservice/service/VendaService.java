package br.com.cryslefundes.javendas.vendaservice.service;

import br.com.cryslefundes.javendas.vendaservice.domain.*;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.AtualizaVendaDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.ProdutoDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.RegistraVendaDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.VendaDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.exception.StatusVendaException;
import br.com.cryslefundes.javendas.vendaservice.repository.VendaRepository;
import br.com.cryslefundes.javendas.vendaservice.service.validation.Validation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VendaService implements VendaUseCase {
    private final VendaRepository repository;
    private final List<Validation<ProdutoDTO>> validacoesDeProduto;
    private final ProdutoService produtoService;
    private final ClienteService clienteService;

    @Autowired
    public VendaService(VendaRepository repository, List<Validation<ProdutoDTO>> validacoesDeProduto, ProdutoService produtoService, ClienteService clienteService) {
        this.repository = repository;
        this. validacoesDeProduto = validacoesDeProduto;
        this.produtoService = produtoService;
        this.clienteService = clienteService;
    }


    @Override
    public Page<VendaDTO> buscaTodasAsVendas(Pageable pageable) {
        return repository.findAll(pageable).map(VendaDTO::new);
    }

    @Override
    public VendaDTO buscaVenda(String id) {
        var venda = findVenda(id);
        return new VendaDTO(venda);
    }

    @Override
    public VendaDTO atualizaVenda(AtualizaVendaDTO dto) {
        var venda = findVenda(dto.id());
        clienteService.existeClienteId(dto.clienteId());
        venda.atualizaVenda(dto.codigo(), dto.clienteId());
        venda = repository.save(venda);
        return new VendaDTO(venda);
    }

    @Override
    public VendaDTO iniciaVenda(RegistraVendaDTO dto) {
        clienteService.existeClienteId(dto.clienteId());
        var venda = new Venda(dto.codigo(), dto.clienteId());
        repository.insert(venda);
        return new VendaDTO(venda);
    }

    @Override
    public void finalizaVenda(String id) {
        var venda = findVenda(id);
        // Antes de finalizar, deve passar todas as validaçôes de pagamento.
        venda.finalizaVenda();
        // Após finalizar a venda, os produtos relacionados são enviados a logística.
        repository.save(venda);
    }

    @Override
    public void cancelaVenda(String id) {
        var venda = findVenda(id);
        // A venda só poderá ser cancelada antes de se terem passado 7 dias para arrependimento.
        venda.cancelaVenda();
        // Após a venda ser cancelada, o processo de reembolso é iniciado.
        repository.save(venda);
    }

    @Override
    public void removeProdutoDaVenda(ProdutoDTO dto) {
        var venda = findVenda(dto.vendaId());

        validacoesDeProduto.forEach(v -> v.valida(dto));

        var produtoQtd = findProdutoQtd(dto.produtoId(), venda);

        venda.removerProduto(produtoQtd, dto.quantidade());
        repository.save(venda);
    }

    @Override
    public void removeTodosProdutos(String id) {
        var venda = findVenda(id);

        StatusVenda status = venda.getStatusVenda();
        if (status == StatusVenda.CANCELADA || status == StatusVenda.CONCLUIDA) {
            throw new StatusVendaException("Não é possível remover todos os produtos de uma venda que esteja cancelada ou concluída.");
        }

        venda.removerTodosProdutos();
        repository.save(venda);
    }

    @Override
    public void adicionaProdutoAVenda(ProdutoDTO dto) {
        var venda = findVenda(dto.vendaId());

        validacoesDeProduto.forEach(v -> v.valida(dto));

        var produtoQtd = findProdutoQtd(dto.produtoId(), venda);

        venda.adicionarProduto(produtoQtd, dto.quantidade());
        repository.save(venda);
    }

    private Venda findVenda(String id) {
        var venda = repository.findById(id);
        if (venda.isEmpty()) throw new EntityNotFoundException("Venda não encontrada.");
        return venda.get();
    }

    private ProdutoQuantidade findProdutoQtd(String produtoId, Venda venda) {
        var produtos = venda.getProdutos();

        var produto = produtos.stream()
                .filter(pq -> pq.getProduto().getId().equals(produtoId))
                .findAny();
        if (produto.isEmpty()) {
           var novoProduto = ProdutoQuantidade.builder()
                   .produto(produtoService.buscaProduto(produtoId))
                   .valorTotal(BigDecimal.ZERO)
                   .quantidade(0)
                   .build();
           return novoProduto;
        }

        return produto.get();
    }
}
