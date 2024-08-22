package com.example.demo.controller;

import com.example.demo.model.Greenhouse;
import com.example.demo.service.GreenhouseService;
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

class GreenhouseControllerTest {

    @Mock
    private GreenhouseService greenhouseService;

    @InjectMocks
    private GreenhouseController greenhouseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllGreenhouses() {
        List<Greenhouse> greenhouses = new ArrayList<>();
        greenhouses.add(new Greenhouse());
        when(greenhouseService.getAllGreenhouses()).thenReturn(greenhouses);

        List<Greenhouse> result = greenhouseController.getAllGreenhouses();

        assertEquals(1, result.size());
        verify(greenhouseService, times(1)).getAllGreenhouses();
    }

    @Test
    void testGetGreenhouseById() {
        Greenhouse greenhouse = new Greenhouse();
        when(greenhouseService.getGreenhouseById(anyLong())).thenReturn(greenhouse);

        ResponseEntity<Greenhouse> response = greenhouseController.getGreenhouseById(1L);

        assertNotNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 200);
        verify(greenhouseService, times(1)).getGreenhouseById(1L);
    }

    @Test
    void testCreateGreenhouse() {
        Greenhouse greenhouse = new Greenhouse();
        when(greenhouseService.saveGreenhouse(any(Greenhouse.class))).thenReturn(greenhouse);

        Greenhouse result = greenhouseController.createGreenhouse(greenhouse);

        assertNotNull(result);
        verify(greenhouseService, times(1)).saveGreenhouse(greenhouse);
    }

    @Test
    void testUpdateGreenhouse() {
        Greenhouse greenhouse = new Greenhouse();
        when(greenhouseService.updateGreenhouse(anyLong(), any(Greenhouse.class))).thenReturn(greenhouse);

        ResponseEntity<Greenhouse> response = greenhouseController.updateGreenhouse(1L, greenhouse);

        assertNotNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 200);
        verify(greenhouseService, times(1)).updateGreenhouse(1L, greenhouse);
    }

    @Test
    void testDeleteGreenhouse() {
        when(greenhouseService.deleteGreenhouse(anyLong())).thenReturn(true);

        ResponseEntity<Void> response = greenhouseController.deleteGreenhouse(1L);

        assertEquals(response.getStatusCodeValue(), 204);
        verify(greenhouseService, times(1)).deleteGreenhouse(1L);
    }
}
