package com.example.demo.repository;

import com.example.demo.model.Greenhouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenhouseRepository extends MongoRepository<Greenhouse, Long> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario
}
