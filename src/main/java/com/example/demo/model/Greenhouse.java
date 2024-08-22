package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Greenhouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float temperaturaInterna;
    private float umiditaInterna;
    private float temperaturaEsterna;
    private float umiditaEsterna;

    @OneToMany(mappedBy = "greenhouse")
    private List<Plant> piante;



    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTemperaturaInterna() {
        return temperaturaInterna;
    }

    public void setTemperaturaInterna(float temperaturaInterna) {
        this.temperaturaInterna = temperaturaInterna;
    }

    public float getUmiditaInterna() {
        return umiditaInterna;
    }

    public void setUmiditaInterna(float umiditaInterna) {
        this.umiditaInterna = umiditaInterna;
    }

    public float getTemperaturaEsterna() {
        return temperaturaEsterna;
    }

    public void setTemperaturaEsterna(float temperaturaEsterna) {
        this.temperaturaEsterna = temperaturaEsterna;
    }

    public float getUmiditaEsterna() {
        return umiditaEsterna;
    }

    public void setUmiditaEsterna(float umiditaEsterna) {
        this.umiditaEsterna = umiditaEsterna;
    }

    public List<Plant> getPiante() {
        return piante;
    }

    public void setPiante(List<Plant> piante) {
        this.piante = piante;
    }
}
