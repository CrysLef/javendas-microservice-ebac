package br.com.cryslefundes.javendas.vendaservice.service;

import br.com.cryslefundes.javendas.vendaservice.adapter.ClienteGateway;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteGateway gateway;

    @Autowired
    public ClienteService(ClienteGateway gateway) {
        this.gateway = gateway;
    }

    public void existeClienteId(String clienteId) {
        if (!(gateway.buscaClienteId(clienteId))) {
            throw new EntityNotFoundException("Cliente não foi cadastrado.");
        }
    }
}
