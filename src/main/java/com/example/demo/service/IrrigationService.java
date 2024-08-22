package com.example.demo.service;

import com.example.demo.model.Actuator;
import com.example.demo.model.Greenhouse;
import com.example.demo.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IrrigationService {

    @Autowired
    private GreenhouseService greenhouseService;

    @Autowired
    private PlantService plantService;

    @Autowired
    private GreenhouseService actuatorService;

    public List<Actuator> getAllIrrigations(Long greenhouseId) {
        Greenhouse greenhouse = greenhouseService.getGreenhouseById(greenhouseId);
        return greenhouse.getPiante().stream()
                .flatMap(pianta -> pianta.getAttuatori().stream())
                .filter(attuatore -> "IRRIGAZIONE".equals(attuatore.getTipo()))
                .toList();
    }

    public Actuator controlIrrigation(Long actuatorId, Long plantId, float quantitaAcqua) {
        Optional<Actuator> optionalActuator = actuatorService.getActuatorById(actuatorId);
        if (optionalActuator.isPresent()) {
            Actuator actuator = optionalActuator.get();
            Plant plant = plantService.getPlantById(plantId);

            actuator.setStato("ON");
            actuator.setDataAttivazione(new Date());
            actuator.setQuantitaAcqua(quantitaAcqua);

            plant.setUltimaIrrigazione(new Date());
            return actuator;
        } else {
            throw new RuntimeException("Attuatore non trovato");
        }
    }
}
