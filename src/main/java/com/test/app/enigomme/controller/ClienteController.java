package com.test.app.enigomme.controller;

import com.test.app.enigomme.entity.Cliente;
import com.test.app.enigomme.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // ✅ Lista clienti
    @GetMapping("/list")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    // ✅ Dettaglio cliente
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    // ✅ Creazione nuovo cliente
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente saved = clienteService.save(cliente);
        return ResponseEntity
                .created(URI.create("/api/clienti/" + saved.getId())) // 201 Created + Location header
                .body(saved);
    }

    // ✅ Modifica cliente esistente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente existing = clienteService.findById(id);
        existing.setNome(cliente.getNome());
        existing.setCognome(cliente.getCognome());
        existing.setEmail(cliente.getEmail());
        existing.setTelefono(cliente.getTelefono());
        Cliente updated = clienteService.save(existing);
        return ResponseEntity.ok(updated);
    }

    // ✅ Eliminazione cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // ✅ Ricerca per nome e cognome
    @GetMapping("/search")
    public ResponseEntity<List<Cliente>> search(@RequestParam(defaultValue = "") String nome,
                                                @RequestParam(defaultValue = "") String cognome) {
        return ResponseEntity.ok(
                clienteService.searchByNomeAndCognome(nome, cognome)
        );
    }
}
