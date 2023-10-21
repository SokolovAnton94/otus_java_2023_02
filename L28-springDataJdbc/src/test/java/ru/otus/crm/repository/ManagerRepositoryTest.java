package ru.otus.crm.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.otus.crm.model.Manager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
@Sql("classpath:init/manager/init.sql")
@Sql(scripts = "classpath:init/manager/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;
    @Test
    void findAllSuccessTest() {
        List<Manager> managers = managerRepository.findAll();
        assertEquals(2, managers.size());

        for (Manager manager : managers) {
            if ("98".equals(manager.getId())) {
                assertEquals(2, manager.getClients().size());
                assertEquals(2, manager.getClientsOrdered().size());
            } else if ("99".equals(manager.getId())) {
                assertEquals(1, manager.getClients().size());
                assertEquals(1, manager.getClientsOrdered().size());
            }
        }
    }
}