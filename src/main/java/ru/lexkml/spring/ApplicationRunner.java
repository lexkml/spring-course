package ru.lexkml.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lexkml.spring.config.ApplicationConfiguration;
import ru.lexkml.spring.database.repository.CrudRepository;

import java.net.URI;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            var maybeCompany = companyRepository.findById(1);

            var uri = context.getBean("uri", URI.class);

            System.out.println(maybeCompany);
        }
    }
}
