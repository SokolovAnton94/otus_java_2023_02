package ru.otus.crm.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.otus.crm.model.TableWithPk;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
@Sql("classpath:init/pktable/init.sql")
@Sql(scripts = "classpath:init/pktable/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TableWithPkRepositoryTest {
    @Autowired
    private TableWithPkRepository tableWithPkRepository;

    @Test
    void saveEntrySuccessTest() {
        TableWithPk.Pk pk = new TableWithPk.Pk("id_part1", "id_part2_test");
        TableWithPk testTableWithPk = new TableWithPk(pk, "");
        tableWithPkRepository.saveEntry(testTableWithPk);
        Optional<TableWithPk> result = tableWithPkRepository.findById(pk);
        assertTrue(result.isPresent());
    }

    @Test
    void findByIdSuccessTest() {
        TableWithPk.Pk pk = new TableWithPk.Pk("id_test1", "id_test2");
        Optional<TableWithPk> result = tableWithPkRepository.findById(pk);
        assertTrue(result.isPresent());
        assertEquals(result.get().getValue(), "testValue");
    }
}