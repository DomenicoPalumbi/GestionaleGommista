package com.test.app.enigomme.service;

import com.test.app.enigomme.entity.Cliente;
import com.test.app.enigomme.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("Cliente non trovato con id: " + id));
    }

    public Cliente save(Cliente cliente) {
        if(clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new RuntimeException("Cliente con questa email già esiste");
        }
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        if(!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente non trovato con id: " + id);
        }
        clienteRepository.deleteById(id);
    }

    public List<Cliente> searchByNomeAndCognome(String nome, String cognome) {
        return clienteRepository.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(nome, cognome);
    }

}
