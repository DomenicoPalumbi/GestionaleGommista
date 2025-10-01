package com.test.app.enigomme.controller;

import com.test.app.enigomme.entity.Pneumatico;
import com.test.app.enigomme.service.PneumaticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pneumatici")
public class PneumaticoController {

    private final PneumaticoService pneumaticoService;

    public PneumaticoController(PneumaticoService pneumaticoService) {
        this.pneumaticoService = pneumaticoService;
    }

    @GetMapping("/list")
    public List<Pneumatico> getAll() {
        return pneumaticoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pneumatico> getById(@PathVariable Long id) {
        return pneumaticoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public Pneumatico create(@RequestBody Pneumatico pneumatico) {
        return pneumaticoService.save(pneumatico);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Pneumatico> update(@PathVariable Long id, @RequestBody Pneumatico pneumatico) {
        return pneumaticoService.findById(id)
                .map(existing -> {
                    pneumatico.setId(id);
                    Pneumatico updated = pneumaticoService.save(pneumatico);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return pneumaticoService.findById(id)
                .map(existing -> {
                    pneumaticoService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
