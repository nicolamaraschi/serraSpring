package com.example.demo.controller;

import com.example.demo.model.Plant;
import com.example.demo.service.PlantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlantControllerTest {

    @Mock
    private PlantService plantService;

    @InjectMocks
    private PlantController plantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPlants() {
        List<Plant> plants = new ArrayList<>();
        plants.add(new Plant());
        when(plantService.getAllPlants()).thenReturn(plants);

        List<Plant> result = plantController.getAllPlants();

        assertEquals(1, result.size());
        verify(plantService, times(1)).getAllPlants();
    }

    @Test
    void testGetPlantById() {
        Plant plant = new Plant();
        when(plantService.getPlantById(anyLong())).thenReturn(plant);

        ResponseEntity<Plant> response = plantController.getPlantById(1L);

        assertNotNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 200);
        verify(plantService, times(1)).getPlantById(1L);
    }

    @Test
    void testCreatePlant() {
        Plant plant = new Plant();
        when(plantService.savePlant(any(Plant.class))).thenReturn(plant);

        Plant result = plantController.createPlant(plant);

        assertNotNull(result);
        verify(plantService, times(1)).savePlant(plant);
    }

    @Test
    void testUpdatePlant() {
        Plant plant = new Plant();
        when(plantService.updatePlant(anyLong(), any(Plant.class))).thenReturn(plant);

        ResponseEntity<Plant> response = plantController.updatePlant(1L, plant);

        assertNotNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 200);
        verify(plantService, times(1)).updatePlant(1L, plant);
    }

    @Test
    void testDeletePlant() {
        when(plantService.deletePlant(anyLong())).thenReturn(true);

        ResponseEntity<Void> response = plantController.deletePlant(1L);

        assertEquals(response.getStatusCodeValue(), 204);
        verify(plantService, times(1)).deletePlant(1L);
    }
}
