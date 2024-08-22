package com.example.demo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MongoDbConnectionTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoClient mongoClient;

    @Test
    public void contextLoads() {
        // Verifica che MongoTemplate sia stato caricato correttamente
        assertThat(mongoTemplate).isNotNull();
    }

    @Test
    public void testDatabaseConnection() {
        // Usa MongoClient per ottenere il MongoDatabase e testare la connessione
        MongoDatabase database = mongoClient.getDatabase("test-database"); // Cambia con il nome del tuo database

        // Verifica se il database non è null
        assertThat(database).isNotNull();

        // Esegui un'operazione semplice come il controllo del nome del database
        String dbName = database.getName();
        assertThat(dbName).isEqualTo("test-database"); // Cambia con il nome del tuo database se necessario
    }
}
