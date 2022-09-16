package ru.lexkml.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ru.lexkml.spring.database.pool.ConnectionPool;
import web.config.WebConfiguration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@Import(WebConfiguration.class)
public class ApplicationConfiguration {

    @Bean()
    public URI uri(@Value("${db.url}") String dbUrl) {
        try {
            return new URI(dbUrl);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public ConnectionPool connectionPool(@Value("${db.user}") String user, @Value("${db.poolSize}") Integer poolSize) {
        return new ConnectionPool(user, poolSize);
    }

    @Bean
    public ConnectionPool connectionPoo2() {
        return new ConnectionPool("test-pool", 150);
    }
}
