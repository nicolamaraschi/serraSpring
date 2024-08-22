package com.example.demo.service;

import com.example.demo.model.Greenhouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreenhouseServiceTest {

    private GreenhouseService greenhouseService;

    @BeforeEach
    void setUp() {
        greenhouseService = new GreenhouseService();
    }

    @Test
    void testSaveGreenhouse() {
        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setTemperaturaInterna(22.5f);

        Greenhouse savedGreenhouse = greenhouseService.saveGreenhouse(greenhouse);

        assertNotNull(savedGreenhouse.getId());
        assertEquals(22.5f, savedGreenhouse.getTemperaturaInterna());
    }

    @Test
    void testGetAllGreenhouses() {
        Greenhouse greenhouse1 = new Greenhouse();
        Greenhouse greenhouse2 = new Greenhouse();

        greenhouseService.saveGreenhouse(greenhouse1);
        greenhouseService.saveGreenhouse(greenhouse2);

        List<Greenhouse> greenhouses = greenhouseService.getAllGreenhouses();

        assertEquals(2, greenhouses.size());
    }

    @Test
    void testGetGreenhouseById() {
        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setTemperaturaInterna(22.5f);

        greenhouseService.saveGreenhouse(greenhouse);
        Greenhouse foundGreenhouse = greenhouseService.getGreenhouseById(greenhouse.getId());

        assertNotNull(foundGreenhouse);
        assertEquals(22.5f, foundGreenhouse.getTemperaturaInterna());
    }

    @Test
    void testUpdateGreenhouse() {
        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setTemperaturaInterna(22.5f);

        greenhouseService.saveGreenhouse(greenhouse);
        greenhouse.setTemperaturaInterna(25.0f);

        Greenhouse updatedGreenhouse = greenhouseService.updateGreenhouse(greenhouse.getId(), greenhouse);

        assertEquals(25.0f, updatedGreenhouse.getTemperaturaInterna());
    }

    @Test
    void testDeleteGreenhouse() {
        Greenhouse greenhouse = new Greenhouse();
        greenhouse.setTemperaturaInterna(22.5f);

        greenhouseService.saveGreenhouse(greenhouse);
        boolean isDeleted = greenhouseService.deleteGreenhouse(greenhouse.getId());

        assertTrue(isDeleted);
        assertNull(greenhouseService.getGreenhouseById(greenhouse.getId()));
    }
}
