package com.dmdev.spring;

import com.dmdev.spring.database.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
public class TestApplicationRunner {

    @MockBean(name = "connectionPool")
    private ConnectionPool connectionPool;

}
