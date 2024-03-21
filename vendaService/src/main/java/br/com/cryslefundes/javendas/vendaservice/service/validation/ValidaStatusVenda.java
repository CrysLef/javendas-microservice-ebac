package br.com.cryslefundes.javendas.vendaservice.service.validation;

import br.com.cryslefundes.javendas.vendaservice.domain.StatusVenda;
import br.com.cryslefundes.javendas.vendaservice.domain.dto.ProdutoDTO;
import br.com.cryslefundes.javendas.vendaservice.domain.exception.StatusVendaException;
import br.com.cryslefundes.javendas.vendaservice.repository.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaStatusVenda implements Validation<ProdutoDTO> {
    private final VendaRepository repository;

    @Autowired
    public ValidaStatusVenda(VendaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void valida(ProdutoDTO dto) {
        var venda = repository.findById(dto.vendaId());
        if (venda.isEmpty()) throw new EntityNotFoundException("Venda não encontrada.");

        StatusVenda status = venda.get().getStatusVenda();
        if (status == StatusVenda.CANCELADA || status == StatusVenda.CONCLUIDA) {
            throw new StatusVendaException("Não é possível atualizar uma venda que esteja cancelada ou concluída.");
        }
    }
}
