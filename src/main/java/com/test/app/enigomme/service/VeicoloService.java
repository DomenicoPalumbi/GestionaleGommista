package com.test.app.enigomme.service;

import com.test.app.enigomme.entity.Veicolo;
import com.test.app.enigomme.repository.VeicoloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeicoloService {

    private final VeicoloRepository veicoloRepository;

    public VeicoloService(VeicoloRepository veicoloRepository) {
        this.veicoloRepository = veicoloRepository;
    }

    public List<Veicolo> findAll() {
        return veicoloRepository.findAll();
    }

    public Optional<Veicolo> findById(Long id) {
        return veicoloRepository.findById(id);
    }

    public Veicolo save(Veicolo veicolo) {
        return veicoloRepository.save(veicolo);
    }

    public void deleteById(Long id) {
        veicoloRepository.deleteById(id);
    }
    public List<Veicolo> findByClienteNomeAndCognome(String nome, String cognome){
     return veicoloRepository.findByClienteNomeContainingIgnoreCaseAndClienteCognomeContainingIgnoreCase(nome ,cognome);
    }
}
