package com.example.demo.service;

import com.example.demo.model.Actuator;
import com.example.demo.model.Greenhouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LightingService {

    @Autowired
    private GreenhouseService greenhouseService;

    @Autowired
    private GreenhouseService actuatorService;

    public List<Actuator> getAllLights(Long greenhouseId) {
        Greenhouse greenhouse = greenhouseService.getGreenhouseById(greenhouseId);
        // Qui supponiamo che Greenhouse abbia una lista di Actuators
        return greenhouse.getPiante().stream()
                .flatMap(pianta -> pianta.getAttuatori().stream())
                .filter(attuatore -> "ILLUMINAZIONE".equals(attuatore.getTipo()))
                .toList();
    }

    public Actuator controlLight(Long actuatorId, String stato) {
        Optional<Actuator> optionalActuator = actuatorService.getActuatorById(actuatorId);
        if (optionalActuator.isPresent()) {
            Actuator actuator = optionalActuator.get();
            actuator.setStato(stato);
            actuator.setDataAttivazione(new Date());
            return actuator;
        } else {
            throw new RuntimeException("Attuatore non trovato");
        }
    }
}
