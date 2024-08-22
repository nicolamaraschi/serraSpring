package com.example.demo.service;

import com.example.demo.model.Actuator;
import com.example.demo.model.Greenhouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VentilationService {

    @Autowired
    private GreenhouseService greenhouseService;

    @Autowired
    private GreenhouseService actuatorService;

    public List<Actuator> getAllVentilations(Long greenhouseId) {
        Greenhouse greenhouse = greenhouseService.getGreenhouseById(greenhouseId);
        return greenhouse.getPiante().stream()
                .flatMap(pianta -> pianta.getAttuatori().stream()) // Assumendo che getAttuatori() restituisca List<Actuator>
                .filter(attuatore -> "VENTILAZIONE".equals(attuatore.getTipo()))
                .toList();
    }


    public Actuator controlVentilation(Long actuatorId, String stato, int velocita) {
        Optional<Actuator> optionalActuator = actuatorService.getActuatorById(actuatorId);
        if (optionalActuator.isPresent()) {
            Actuator actuator = optionalActuator.get();
            actuator.setStato(stato);
            actuator.setVelocita(velocita);
            actuator.setDataAttivazione(new Date());
            return actuator;
        } else {
            throw new RuntimeException("Attuatore non trovato");
        }
    }
}
