package com.joaojulioproenca.cliente.infrastructure.repository;


import com.joaojulioproenca.cliente.infrastructure.entity.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByEmail(String email);

    Optional<Cliente> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
