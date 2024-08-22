package com.example.demo.controller;

import com.example.demo.model.Plant;
import com.example.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    // ottieni tutte le piante
    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    //cerca pianta per id
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        Plant plant = plantService.getPlantById(id);
        if (plant != null) {
            return ResponseEntity.ok(plant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //aggiungi una pianta
    @PostMapping
    public Plant createPlant(@RequestBody Plant plant) {
        return plantService.savePlant(plant);
    }

    //aggiorna pianta per id
    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody Plant plantDetails) {
        Plant updatedPlant = plantService.updatePlant(id, plantDetails);
        if (updatedPlant != null) {
            return ResponseEntity.ok(updatedPlant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //elimina pianta per id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        boolean isDeleted = plantService.deletePlant(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
