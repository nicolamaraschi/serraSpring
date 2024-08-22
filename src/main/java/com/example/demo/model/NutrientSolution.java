package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class NutrientSolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float ph;

    @Enumerated(EnumType.STRING)
    private FertilizerType fertilizerType; // Bicomp e Tricomp

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FertilizerComponent> components;

    private float quantityUsed; // Quantità di fertilizzante usata

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public FertilizerType getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(FertilizerType fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public List<FertilizerComponent> getComponents() {
        return components;
    }

    public void setComponents(List<FertilizerComponent> components) {
        this.components = components;
    }

    public float getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(float quantityUsed) {
        this.quantityUsed = quantityUsed;
    }
}
