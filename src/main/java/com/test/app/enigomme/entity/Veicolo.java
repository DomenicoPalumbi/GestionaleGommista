package com.test.app.enigomme.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "veicolo")
public class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modello;

    @ManyToOne
    @JoinColumn(name = "cliente_id")  // FK verso cliente
    private Cliente cliente;

    @OneToMany(mappedBy = "veicolo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pneumatico> pneumatici;

    // Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pneumatico> getPneumatici() {
        return pneumatici;
    }

    public void setPneumatici(List<Pneumatico> pneumatici) {
        this.pneumatici = pneumatici;
    }
}
