package br.com.cryslefundes.javendas.vendaservice.domain;

import br.com.cryslefundes.javendas.vendaservice.domain.dto.AtualizaVendaDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.ProdutoDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.RegistraVendaDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.VendaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VendaUseCase {
    Page<VendaDTO> buscaTodasAsVendas(Pageable pageable);
    VendaDTO buscaVenda(String id);
    VendaDTO atualizaVenda(AtualizaVendaDTO dto);
    VendaDTO iniciaVenda(RegistraVendaDTO dto);
    void finalizaVenda(String id);
    void cancelaVenda(String id);
    void removeProdutoDaVenda(ProdutoDTO dto);
    void removeTodosProdutos(String id);
    void adicionaProdutoAVenda(ProdutoDTO dto);
}
