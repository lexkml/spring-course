package ru.lexkml.spring;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.lexkml.spring.database.pool.ConnectionPool;

@TestConfiguration
public class TestApplicationRunner {

    @MockBean(name = "connectionPool")
    private ConnectionPool connectionPool;

}
