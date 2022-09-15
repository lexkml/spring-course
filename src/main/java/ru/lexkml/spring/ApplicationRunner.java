package ru.lexkml.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lexkml.spring.config.ApplicationConfiguration;
import ru.lexkml.spring.service.CompanyService;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {

            var companyService = context.getBean(CompanyService.class);

            companyService.findById(1);

            System.out.println();
        }
    }
}
