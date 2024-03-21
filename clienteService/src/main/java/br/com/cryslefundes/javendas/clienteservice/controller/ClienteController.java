package br.com.cryslefundes.javendas.clienteservice.controller;

import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.ClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.RegisterClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.domain.cliente.dto.UpdateClienteDTO;
import br.com.cryslefundes.javendas.clienteservice.service.ClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> getAllClientes(@ParameterObject @PageableDefault(sort = "nome") Pageable pagination) {
        return ResponseEntity.ok(service.getAllClientes(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable String id) {
        return ResponseEntity.ok(service.getCliente(id));
    }

    @GetMapping("/{id}/is-cadastrado")
    public ResponseEntity<Boolean> isClienteCadastrado(@PathVariable String id) {
        return ResponseEntity.ok(service.isClienteCadastrado(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDTO> registerCliente(@RequestBody @Valid RegisterClienteDTO dto) {
        return ResponseEntity.ok(service.registerCliente(dto));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ClienteDTO> updateCliente(@Valid UpdateClienteDTO dto) {
        return ResponseEntity.ok(service.updateCliente(dto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removeCliente(@PathVariable String id) {
        service.removeCliente(id);
        return ResponseEntity.noContent().build();
    }
}
