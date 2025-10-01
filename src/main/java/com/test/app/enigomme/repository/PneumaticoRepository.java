package com.test.app.enigomme.repository;

import com.test.app.enigomme.entity.Pneumatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PneumaticoRepository extends JpaRepository<Pneumatico, Long> {
    List<Pneumatico> findByVeicoloClienteNomeContainingIgnoreCaseAndVeicoloClienteCognomeContainingIgnoreCase(String nome, String cognome);

}
