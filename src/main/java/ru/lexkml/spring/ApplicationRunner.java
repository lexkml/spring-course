package ru.lexkml.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lexkml.spring.database.repository.CompanyRepository;

public class ApplicationRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");

        var companyRepository = context.getBean("companyRepository", CompanyRepository.class);

        System.out.println();
    }
}
