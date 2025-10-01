package com.test.app.enigomme.controller;

import com.test.app.enigomme.entity.Veicolo;
import com.test.app.enigomme.service.VeicoloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/veicoli")
public class VeicoloController {

    private final VeicoloService veicoloService;

    public VeicoloController(VeicoloService veicoloService) {
        this.veicoloService = veicoloService;
    }

    @GetMapping("/list")
    public List<Veicolo> getAll() {
        return veicoloService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veicolo> getById(@PathVariable Long id) {
        return veicoloService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public Veicolo create(@RequestBody Veicolo veicolo) {
        return veicoloService.save(veicolo);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Veicolo> update(@PathVariable Long id, @RequestBody Veicolo veicolo) {
        return veicoloService.findById(id)
                .map(existing -> {
                    veicolo.setId(id);
                    Veicolo updated = veicoloService.save(veicolo);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return veicoloService.findById(id)
                .map(existing -> {
                    veicoloService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
