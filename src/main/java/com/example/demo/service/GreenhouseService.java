package com.example.demo.service;

import com.example.demo.model.Actuator;
import com.example.demo.model.Greenhouse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GreenhouseService {

    // Inizializzazione della lista
    private List<Greenhouse> greenhouses = new ArrayList<>();

    public List<Greenhouse> getAllGreenhouses() {
        return new ArrayList<>(greenhouses); // Restituisce una copia per evitare modifiche esterne
    }

    public Greenhouse getGreenhouseById(Long id) {
        return greenhouses.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Serra non trovata"));
    }

    public Greenhouse saveGreenhouse(Greenhouse greenhouse) {
        if (greenhouse.getId() == null) {
            greenhouse.setId((long) (greenhouses.size() + 1)); // Simula un'assegnazione di ID
        }
        greenhouses.add(greenhouse);
        return greenhouse;
    }

    public Greenhouse updateGreenhouse(Long id, Greenhouse greenhouseDetails) {
        Optional<Greenhouse> optionalGreenhouse = greenhouses.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst();

        if (optionalGreenhouse.isPresent()) {
            Greenhouse greenhouse = optionalGreenhouse.get();
            greenhouse.setTemperaturaInterna(greenhouseDetails.getTemperaturaInterna());
            greenhouse.setUmiditaInterna(greenhouseDetails.getUmiditaInterna());
            greenhouse.setTemperaturaEsterna(greenhouseDetails.getTemperaturaEsterna());
            greenhouse.setUmiditaEsterna(greenhouseDetails.getUmiditaEsterna());
            return greenhouse;
        } else {
            throw new RuntimeException("Serra non trovata");
        }
    }

    public boolean deleteGreenhouse(Long id) {
        return greenhouses.removeIf(g -> g.getId().equals(id));
    }

    public Optional<Actuator> getActuatorById(Long id) {
        return greenhouses.stream()
                .flatMap(greenhouse -> greenhouse.getPiante().stream())
                .flatMap(pianta -> pianta.getAttuatori().stream())
                .filter(attuatore -> attuatore.getId().equals(id))
                .findFirst();
    }
}
