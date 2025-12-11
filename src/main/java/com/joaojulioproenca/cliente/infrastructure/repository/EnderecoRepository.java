package com.joaojulioproenca.cliente.infrastructure.repository;


import com.joaojulioproenca.cliente.infrastructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
