package com.joaojulioproenca.cliente.business;

import com.joaojulioproenca.cliente.business.converter.ClienteConverter;
import com.joaojulioproenca.cliente.business.dto.ClienteDTO;
import com.joaojulioproenca.cliente.infrastructure.entity.Cliente;
import com.joaojulioproenca.cliente.infrastructure.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteConverter clienteConverter;

    public ClienteDTO salvaCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteConverter.paraCliente(clienteDTO);
         cliente = clienteRepository.save(cliente);
         return clienteConverter.paraClienteDTO(cliente);

    }
}
