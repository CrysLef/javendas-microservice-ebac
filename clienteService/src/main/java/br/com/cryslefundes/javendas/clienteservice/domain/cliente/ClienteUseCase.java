package br.com.cryslefundes.javendas.clienteservice.domain.cliente;

import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.ClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.RegisterClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.UpdateClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteUseCase {
    Page<ClienteDTO> getAllClientes(Pageable pagination);
    ClienteDTO getCliente(String id);
    ClienteDTO registerCliente(RegisterClienteDTO dto);
    ClienteDTO updateCliente(UpdateClienteDTO dto);
    Boolean isClienteCadastrado(String id);
    void removeCliente(String id);
}
