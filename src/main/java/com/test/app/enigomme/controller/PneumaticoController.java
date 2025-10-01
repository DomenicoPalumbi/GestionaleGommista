package com.test.app.enigomme.controller;

import com.test.app.enigomme.entity.Pneumatico;
import com.test.app.enigomme.service.PneumaticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/pneumatici")
public class PneumaticoController {

    private final PneumaticoService pneumaticoService;

    public PneumaticoController(PneumaticoService pneumaticoService) {
        this.pneumaticoService = pneumaticoService;
    }

    // Lista di tutti gli pneumatici
    @GetMapping("/list")
    public ResponseEntity<List<Pneumatico>> getAll() {
        return ResponseEntity.ok(pneumaticoService.findAll());
    }

    // Recupera pneumatico per id
    @GetMapping("/{id}")
    public ResponseEntity<Pneumatico> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pneumaticoService.findById(id));
    }

    // Crea nuovo pneumatico
    @PostMapping("/new")
    public ResponseEntity<Pneumatico> create(@RequestBody Pneumatico pneumatico) {
        return ResponseEntity.ok(pneumaticoService.save(pneumatico));
    }

    // Aggiorna pneumatico esistente
    @PutMapping("/edit/{id}")
    public ResponseEntity<Pneumatico> update(@PathVariable Long id, @RequestBody Pneumatico pneumatico) {
        pneumatico.setId(id);
        return ResponseEntity.ok(pneumaticoService.save(pneumatico));
    }

    // Elimina pneumatico
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pneumaticoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Cerca pneumatici per cliente (nome + cognome)
    @GetMapping("/search")
    public ResponseEntity<List<Pneumatico>> search(
            @RequestParam(defaultValue = "") String nome,
            @RequestParam(defaultValue = "") String cognome) {
        return ResponseEntity.ok(
                pneumaticoService.findByClienteNomeAndCognome(nome, cognome)
        );
    }
}
