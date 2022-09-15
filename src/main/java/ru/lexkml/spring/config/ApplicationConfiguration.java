package ru.lexkml.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import web.config.WebConfiguration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "ru.lexkml.spring")
//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
public class ApplicationConfiguration {

    @Value("${db.url}")
    private String dbUrl;

    @Bean
    public URI uri() {
        try {
            return new URI(dbUrl);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
