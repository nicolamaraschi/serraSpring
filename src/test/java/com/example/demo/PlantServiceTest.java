package com.example.demo.service;

import com.example.demo.model.Plant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlantServiceTest {

    private PlantService plantService;

    @BeforeEach
    void setUp() {
        plantService = new PlantService();
    }

    @Test
    void testSavePlant() {
        Plant plant = new Plant();
        plant.setNome("Rosa");
        plant.setDataPiantagione(new Date());
        plant.setUmiditaTerreno(50.0f);

        Plant savedPlant = plantService.savePlant(plant);

        assertNotNull(savedPlant.getId());
        assertEquals("Rosa", savedPlant.getNome());
    }

    @Test
    void testGetAllPlants() {
        Plant plant1 = new Plant();
        plant1.setNome("Rosa");

        Plant plant2 = new Plant();
        plant2.setNome("Tulipano");

        plantService.savePlant(plant1);
        plantService.savePlant(plant2);

        List<Plant> plants = plantService.getAllPlants();

        assertEquals(2, plants.size());
    }

    @Test
    void testGetPlantById() {
        Plant plant = new Plant();
        plant.setNome("Rosa");

        plantService.savePlant(plant);
        Plant foundPlant = plantService.getPlantById(plant.getId());

        assertNotNull(foundPlant);
        assertEquals("Rosa", foundPlant.getNome());
    }

    @Test
    void testUpdatePlant() {
        Plant plant = new Plant();
        plant.setNome("Rosa");

        plantService.savePlant(plant);
        plant.setNome("Tulipano");

        Plant updatedPlant = plantService.updatePlant(plant.getId(), plant);

        assertEquals("Tulipano", updatedPlant.getNome());
    }

    @Test
    void testDeletePlant() {
        Plant plant = new Plant();
        plant.setNome("Rosa");

        plantService.savePlant(plant);
        boolean isDeleted = plantService.deletePlant(plant.getId());

        assertTrue(isDeleted);
        assertNull(plantService.getPlantById(plant.getId()));
    }
}
