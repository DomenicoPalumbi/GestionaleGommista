package com.test.app.enigomme.service;

import com.test.app.enigomme.entity.Veicolo;
import com.test.app.enigomme.repository.VeicoloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeicoloService {

    private final VeicoloRepository veicoloRepository;

    public VeicoloService(VeicoloRepository veicoloRepository) {
        this.veicoloRepository = veicoloRepository;
    }

    public List<Veicolo> findAll() {
        return veicoloRepository.findAll();
    }

    public Veicolo findById(Long id) {
        return veicoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veicolo non trovato con id: " + id));
    }

    public Veicolo save(Veicolo veicolo) {
        return veicoloRepository.save(veicolo);
    }

    public void deleteById(Long id) {
        if (!veicoloRepository.existsById(id)) {
            throw new RuntimeException("Veicolo non trovato con id: " + id);
        }
        veicoloRepository.deleteById(id);
    }

    public List<Veicolo> findByClienteNomeAndCognome(String nome, String cognome) {
        return veicoloRepository
                .findByClienteNomeContainingIgnoreCaseAndClienteCognomeContainingIgnoreCase(nome, cognome);
    }
}
