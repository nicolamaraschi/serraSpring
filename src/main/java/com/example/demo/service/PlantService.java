package com.example.demo.service;

import com.example.demo.model.Plant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlantService {


    private List<Plant> plants = new ArrayList<>();

    public List<Plant> getAllPlants() {
        return plants;
    }

    public Plant getPlantById(Long id) {
        return plants.stream()
                .filter(plant -> plant.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Plant savePlant(Plant plant) {
        plants.add(plant);
        return plant;
    }

    public Plant updatePlant(Long id, Plant plantDetails) {
        Optional<Plant> optionalPlant = plants.stream()
                .filter(plant -> plant.getId().equals(id))
                .findFirst();

        if (optionalPlant.isPresent()) {
            Plant plant = optionalPlant.get();
            plant.setNome(plantDetails.getNome());
            plant.setStato(plantDetails.getStato());
            plant.setUmiditaTerreno(plantDetails.getUmiditaTerreno());
            plant.setDataPiantagione(plantDetails.getDataPiantagione());
            return plant;
        } else {
            return null;
        }
    }

    public boolean deletePlant(Long id) {
        return plants.removeIf(plant -> plant.getId().equals(id));
    }
}
