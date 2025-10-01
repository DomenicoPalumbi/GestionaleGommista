package com.test.app.enigomme.repository;

import com.test.app.enigomme.entity.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, Long> {
    List<Veicolo> findByClienteNomeContainingIgnoreCaseAndClienteCognomeContainingIgnoreCase(String nome, String cognome);

}
