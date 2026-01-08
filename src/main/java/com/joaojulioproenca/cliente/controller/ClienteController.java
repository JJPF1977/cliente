package com.joaojulioproenca.cliente.controller;

import com.joaojulioproenca.cliente.business.ClienteService;
import com.joaojulioproenca.cliente.business.dto.ClienteDTO;
import com.joaojulioproenca.cliente.infrastructure.entity.Cliente;
import com.joaojulioproenca.cliente.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService clienteService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    @PostMapping
    public ResponseEntity<ClienteDTO> salvaCliente(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.salvaCliente(clienteDTO));
    }
    @PostMapping("/login")
    public String login(@RequestBody ClienteDTO clienteDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(clienteDTO.getEmail(),
                        clienteDTO.getSenha())
        );
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }


    @GetMapping
    public ResponseEntity<Cliente> buscaClientePorEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(clienteService.buscarClientePorEmail(email));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletaClientePorEmail(@PathVariable String email){
        clienteService.deletaClientePorEmail(email);
        return ResponseEntity.ok().build();
    }

}
