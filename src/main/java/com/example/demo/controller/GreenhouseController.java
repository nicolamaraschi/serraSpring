package com.example.demo.controller;

import com.example.demo.model.Greenhouse;
import com.example.demo.service.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/greenhouse")
public class GreenhouseController {

    @Autowired
    private GreenhouseService greenhouseService;

    @GetMapping
    public List<Greenhouse> getAllGreenhouses() {
        return greenhouseService.getAllGreenhouses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greenhouse> getGreenhouseById(@PathVariable Long id) {
        Greenhouse greenhouse = greenhouseService.getGreenhouseById(id);
        if (greenhouse != null) {
            return ResponseEntity.ok(greenhouse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Greenhouse createGreenhouse(@RequestBody Greenhouse greenhouse) {
        return greenhouseService.saveGreenhouse(greenhouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Greenhouse> updateGreenhouse(@PathVariable Long id, @RequestBody Greenhouse greenhouseDetails) {
        Greenhouse updatedGreenhouse = greenhouseService.updateGreenhouse(id, greenhouseDetails);
        if (updatedGreenhouse != null) {
            return ResponseEntity.ok(updatedGreenhouse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreenhouse(@PathVariable Long id) {
        boolean isDeleted = greenhouseService.deleteGreenhouse(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
