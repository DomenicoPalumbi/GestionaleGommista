package com.test.app.enigomme.service;

import com.test.app.enigomme.entity.Pneumatico;
import com.test.app.enigomme.repository.PneumaticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PneumaticoService {

    private final PneumaticoRepository pneumaticoRepository;

    public PneumaticoService(PneumaticoRepository pneumaticoRepository) {
        this.pneumaticoRepository = pneumaticoRepository;
    }

    public List<Pneumatico> findAll() {
        return pneumaticoRepository.findAll();
    }

    public Pneumatico findById(Long id) {
        return pneumaticoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pneumatico con id " + id + " non trovato"));
    }

    public Pneumatico save(Pneumatico pneumatico) {
        return pneumaticoRepository.save(pneumatico);
    }

    public void deleteById(Long id) {
        if (!pneumaticoRepository.existsById(id)) {
            throw new RuntimeException("Pneumatico con id " + id + " non trovato");
        }
        pneumaticoRepository.deleteById(id);
    }

    public List<Pneumatico> findByClienteNomeAndCognome(String nome, String cognome) {
        return pneumaticoRepository
                .findByVeicoloClienteNomeContainingIgnoreCaseAndVeicoloClienteCognomeContainingIgnoreCase(nome, cognome);
    }
}
