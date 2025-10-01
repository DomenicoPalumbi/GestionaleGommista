package com.test.app.enigomme.repository;

import com.test.app.enigomme.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(String nome, String cognome);
}
