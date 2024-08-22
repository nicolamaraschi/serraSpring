package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Actuator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String stato; // Es. "ON", "OFF"
    private Date dataAttivazione;

    private String tipo; // Es. "ILLUMINAZIONE", "VENTILAZIONE", "IRRIGAZIONE"

    private Integer velocita; // Utilizzato solo per attuatori di ventilazione

    // Relazione con la Pianta (opzionale, se necessario)
    @ManyToOne
    @JoinColumn(name = "pianta_id")
    private Plant pianta;

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

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Date getDataAttivazione() {
        return dataAttivazione;
    }

    public void setDataAttivazione(Date dataAttivazione) {
        this.dataAttivazione = dataAttivazione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getVelocita() {
        return velocita;
    }

    public void setVelocita(Integer velocita) {
        if ("VENTILAZIONE".equals(this.tipo)) {
            this.velocita = velocita;
        } else {
            throw new UnsupportedOperationException("La velocità può essere impostata solo per attuatori di tipo VENTILAZIONE");
        }
    }

    public Plant getPianta() {
        return pianta;
    }

    public void setPianta(Plant pianta) {
        this.pianta = pianta;
    }

    public void setQuantitaAcqua(float quantitaAcqua) {
    }
}
