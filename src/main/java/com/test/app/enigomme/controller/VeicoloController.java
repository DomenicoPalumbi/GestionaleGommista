package com.test.app.enigomme.controller;

import com.test.app.enigomme.entity.Veicolo;
import com.test.app.enigomme.service.VeicoloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/veicoli")
public class VeicoloController {

    private final VeicoloService veicoloService;

    public VeicoloController(VeicoloService veicoloService) {
        this.veicoloService = veicoloService;
    }

    // ✅ Lista di tutti i veicoli
    @GetMapping("/list")
    public ResponseEntity<List<Veicolo>> getAll() {
        return ResponseEntity.ok(veicoloService.findAll());
    }

    // ✅ Recupera veicolo per id
    @GetMapping("/{id}")
    public ResponseEntity<Veicolo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(veicoloService.findById(id));
    }

    // ✅ Crea nuovo veicolo
    @PostMapping("/new")
    public ResponseEntity<Veicolo> create(@RequestBody Veicolo veicolo) {
        return ResponseEntity.ok(veicoloService.save(veicolo));
    }

    // ✅ Aggiorna veicolo esistente
    @PutMapping("/edit/{id}")
    public ResponseEntity<Veicolo> update(@PathVariable Long id, @RequestBody Veicolo veicolo) {
        Veicolo existing = veicoloService.findById(id);
        existing.setMarca(veicolo.getMarca());
        existing.setModello(veicolo.getModello());
        existing.setCliente(veicolo.getCliente());
        // Non tocchiamo pneumatici qui, li gestiremo separatamente
        Veicolo updated = veicoloService.save(existing);
        return ResponseEntity.ok(updated);
    }

    // ✅ Elimina veicolo
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        veicoloService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Ricerca veicoli per cliente (nome + cognome)
    @GetMapping("/search")
    public ResponseEntity<List<Veicolo>> search(
            @RequestParam(defaultValue = "") String nome,
            @RequestParam(defaultValue = "") String cognome) {
        return ResponseEntity.ok(
                veicoloService.findByClienteNomeAndCognome(nome, cognome)
        );
    }
}
