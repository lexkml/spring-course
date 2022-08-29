package ru.lexkml.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lexkml.spring.database.repository.CrudRepository;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
