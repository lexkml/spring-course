package ru.lexkml.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.lexkml.spring.database.pool.ConnectionPool;
import web.config.WebConfiguration;

@Configuration
@Import(WebConfiguration.class)
public class ApplicationConfiguration {
    @Bean
    public ConnectionPool connectionPool(@Value("${db.user}") String user, @Value("${db.poolSize}") Integer poolSize) {
        return new ConnectionPool(user, poolSize);
    }

    @Bean
    public ConnectionPool connectionPoo2() {
        return new ConnectionPool("test-pool", 150);
    }
}
