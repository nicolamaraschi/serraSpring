package com.example.demo.repository;

import com.example.demo.model.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends MongoRepository<Plant, Long> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
}
