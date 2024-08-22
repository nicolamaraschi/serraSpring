package com.example.demo.model;

import com.example.demo.service.IrrigationService;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private StatoPianta stato;

    private Date dataPiantagione;
    private float umiditaTerreno;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private IrrigationService irrigationService;

    @OneToMany(mappedBy = "pianta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actuator> attuatori;

    private Date ultimaIrrigazione;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatoPianta getStato() {
        return stato;
    }

    public void setStato(StatoPianta stato) {
        this.stato = stato;
    }

    public Date getDataPiantagione() {
        return dataPiantagione;
    }

    public void setDataPiantagione(Date dataPiantagione) {
        this.dataPiantagione = dataPiantagione;
    }

    public float getUmiditaTerreno() {
        return umiditaTerreno;
    }

    public void setUmiditaTerreno(float umiditaTerreno) {
        this.umiditaTerreno = umiditaTerreno;
    }

    public IrrigationService getIrrigationSystem() {
        return irrigationService;
    }

    public void setIrrigationSystem(IrrigationService irrigationSystem) {
        this.irrigationService = irrigationSystem;
    }

    public List<Actuator> getAttuatori() {
        return attuatori;
    }

    public void setAttuatori(List<Actuator> attuatori) {
        this.attuatori = attuatori;
    }

    public Date getUltimaIrrigazione() {
        return ultimaIrrigazione;
    }

    public void setUltimaIrrigazione(Date ultimaIrrigazione) {
        this.ultimaIrrigazione = ultimaIrrigazione;
    }
}
