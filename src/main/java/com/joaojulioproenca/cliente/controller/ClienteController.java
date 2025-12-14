package com.joaojulioproenca.cliente.controller;

import com.joaojulioproenca.cliente.business.ClienteService;
import com.joaojulioproenca.cliente.business.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> salvaCliente(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.salvaCliente(clienteDTO));
    }

}
