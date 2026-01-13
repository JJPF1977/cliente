package com.joaojulioproenca.cliente.business;

import com.joaojulioproenca.cliente.business.converter.ClienteConverter;
import com.joaojulioproenca.cliente.business.dto.ClienteDTO;
import com.joaojulioproenca.cliente.infrastructure.entity.Cliente;
import com.joaojulioproenca.cliente.infrastructure.exceptions.ConflictException;
import com.joaojulioproenca.cliente.infrastructure.exceptions.ResourceNotFoundException;
import com.joaojulioproenca.cliente.infrastructure.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class ClienteService {


    private final ClienteRepository clienteRepository;
    private final ClienteConverter clienteConverter;
    private final PasswordEncoder passwordEncoder;

    public ClienteDTO salvaCliente(ClienteDTO clienteDTO){
        emailExiste(clienteDTO.getEmail());
        clienteDTO.setSenha(passwordEncoder.encode(clienteDTO.getSenha()));
        Cliente cliente = clienteConverter.paraCliente(clienteDTO);
         cliente = clienteRepository.save(cliente);
         return clienteConverter.paraClienteDTO(cliente);

    }
    public void emailExiste(String email){
        try {

            boolean existe = verificaEmailExistente(email);
            if (existe){
                throw new ConflictException("Email já cadastrado" + email);

            }
        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado", e.getCause());
        }



    }
    public boolean verificaEmailExistente(String email){
        return clienteRepository.existsByEmail(email);
    }

    public Cliente buscarClientePorEmail(String email){
        return clienteRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email nao encontrado" + email));
    }

    public void deletaClientePorEmail(String email){
        clienteRepository.deleteByEmail(email);
    }
}
