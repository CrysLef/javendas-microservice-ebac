package br.com.cryslefundes.javendas.clienteservice.service;

import br.com.cryslefundes.javendas.clienteservice.domain.cliente.*;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.ClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.RegisterClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.UpdateClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteService implements ClienteUseCase {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ClienteDTO> getAllClientes(Pageable pagination) {
        return repository.findAll(pagination).map(ClienteDTO::new);
    }

    @Override
    public ClienteDTO getCliente(String id) {
        Optional<Cliente> maybeCliente = repository.findById(id);
        if (maybeCliente.isPresent()) {
            Cliente cliente = maybeCliente.get();
            return new ClienteDTO(cliente);
        }
        throw new EntityNotFoundException("Cliente não encontrado.");
    }

    @Override
    public ClienteDTO registerCliente(RegisterClienteDTO dto) {
        var cliente = new Cliente(dto);
        repository.insert(cliente);
        return new ClienteDTO(cliente);
    }

    @Override
    public ClienteDTO updateCliente(UpdateClienteDTO dto) {
        Optional<Cliente> maybeCliente = repository.findById(dto.id());
        if (maybeCliente.isPresent()) {
            Cliente cliente = maybeCliente.get();
            cliente.updateInfo(dto);
            cliente = repository.save(cliente);
            return new ClienteDTO(cliente);
        }
        throw new EntityNotFoundException("Cliente não encontrado.");
    }

    @Override
    public Boolean isClienteCadastrado(String id) {
        return repository.existsById(id);
    }

    @Override
    public void removeCliente(String id) {
        repository.deleteById(id);
    }
}
