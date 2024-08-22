package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo; // Es. "Temperatura", "Umidità"
    private float valore;
    private Date dataLettura;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValore() {
        return valore;
    }

    public void setValore(float valore) {
        this.valore = valore;
    }

    public Date getDataLettura() {
        return dataLettura;
    }

    public void setDataLettura(Date dataLettura) {
        this.dataLettura = dataLettura;
    }

    public Plant getPianta() {
        return pianta;
    }

    public void setPianta(Plant pianta) {
        this.pianta = pianta;
    }
}
