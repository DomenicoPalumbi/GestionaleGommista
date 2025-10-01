package com.test.app.enigomme.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pneumatico")
public class Pneumatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modello;
    private String dimensione;
    private String matricolaDot;
    private String battistrada;
    private Integer numeroPezzi;

    @Temporal(TemporalType.DATE)
    private Date dataDeposito;

    @ManyToOne
    @JoinColumn(name = "veicolo_id")
    private Veicolo veicolo;

    @Override
    public String toString() {
        return "Pneumatico{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", dimensione='" + dimensione + '\'' +
                ", matricolaDot='" + matricolaDot + '\'' +
                ", battistrada='" + battistrada + '\'' +
                ", numeroPezzi=" + numeroPezzi +
                ", dataDeposito=" + dataDeposito +
                '}';
    }

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

    public String getDimensione() {
        return dimensione;
    }

    public void setDimensione(String dimensione) {
        this.dimensione = dimensione;
    }

    public String getMatricolaDot() {
        return matricolaDot;
    }

    public void setMatricolaDot(String matricolaDot) {
        this.matricolaDot = matricolaDot;
    }

    public String getBattistrada() {
        return battistrada;
    }

    public void setBattistrada(String battistrada) {
        this.battistrada = battistrada;
    }

    public Integer getNumeroPezzi() {
        return numeroPezzi;
    }

    public void setNumeroPezzi(Integer numeroPezzi) {
        this.numeroPezzi = numeroPezzi;
    }

    public Date getDataDeposito() {
        return dataDeposito;
    }

    public void setDataDeposito(Date dataDeposito) {
        this.dataDeposito = dataDeposito;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }
}
