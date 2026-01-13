package com.joaojulioproenca.cliente.infrastructure.repository;


import com.joaojulioproenca.cliente.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
