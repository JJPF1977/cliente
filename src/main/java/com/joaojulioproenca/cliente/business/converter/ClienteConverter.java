package com.joaojulioproenca.cliente.business.converter;

import com.joaojulioproenca.cliente.business.dto.ClienteDTO;
import com.joaojulioproenca.cliente.business.dto.EnderecoDTO;
import com.joaojulioproenca.cliente.business.dto.TelefoneDTO;
import com.joaojulioproenca.cliente.infrastructure.entity.Cliente;
import com.joaojulioproenca.cliente.infrastructure.entity.Endereco;
import com.joaojulioproenca.cliente.infrastructure.entity.Telefone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConverter {

    public Cliente paraCliente(ClienteDTO clienteDTO) {
        return Cliente.builder()

                .nome(clienteDTO.getNome())
                .email(clienteDTO.getEmail())
                .senha(clienteDTO.getSenha())
                .enderecos(paraListaEndereco(clienteDTO.getEnderecos()))
                .telefones(paraListaTelefones(clienteDTO.getTelefones()))

                .build();

    }
    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoDTO enderecoDTO : enderecoDTOS){
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()

                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())

                .build();
    }
    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();

    }
    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())

                .build();
    }

    //METODO CONTRARIO

    public ClienteDTO paraClienteDTO(Cliente clienteDTO) {
        return ClienteDTO.builder()

                .nome(clienteDTO.getNome())
                .email(clienteDTO.getEmail())
                .senha(clienteDTO.getSenha())
                .enderecos(paraListaEnderecoDTO(clienteDTO.getEnderecos()))
                .telefones(paraListaTelefonesDTO(clienteDTO.getTelefones()))

                .build();

    }
    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS){
        List<EnderecoDTO> enderecos = new ArrayList<>();
        for(Endereco enderecoDTO : enderecoDTOS){
            enderecos.add(paraEnderecoDTO(enderecoDTO));
        }
        return enderecos;
    }

    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO){
        return EnderecoDTO.builder()

                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())

                .build();
    }
    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();

    }
    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO){
        return TelefoneDTO.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())

                .build();
    }

}
