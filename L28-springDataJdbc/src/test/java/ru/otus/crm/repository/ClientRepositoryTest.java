package ru.otus.crm.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.otus.crm.model.Client;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
@Sql("classpath:init/client/init.sql")
@Sql(scripts = "classpath:init/client/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    private final String testClientName = "testClient";
    @Test
    void findByNameSuccessTest() {
        Optional<Client> client = clientRepository.findByName(testClientName);
        assertTrue(client.isPresent());
        assertEquals(testClientName, client.get().getName());
    }

    @Test
    void findByNameIgnoreCaseSuccessTest() {
        Optional<Client> client = clientRepository.findByNameIgnoreCase (testClientName.toUpperCase());
        assertTrue(client.isPresent());
        assertEquals(testClientName, client.get().getName());
    }

    @Test
    void updateNameSuccessTest() {
        String newName = "newClientName";
        clientRepository.updateName (1, newName);
        Optional<Client> client = clientRepository.findByName (newName);
        assertTrue(client.isPresent());
        assertEquals(newName, client.get().getName());
    }
}