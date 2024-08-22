package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class IrrigationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private float waterAmount;
    private NutrientSolution nutrientSolutionUsed;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(float waterAmount) {
        this.waterAmount = waterAmount;
    }

    public NutrientSolution getNutrientSolutionUsed() {
        return nutrientSolutionUsed;
    }

    public void setNutrientSolutionUsed(NutrientSolution nutrientSolutionUsed) {
        this.nutrientSolutionUsed = nutrientSolutionUsed;
    }
}
