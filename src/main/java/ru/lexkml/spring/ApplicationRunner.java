package ru.lexkml.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lexkml.spring.config.ApplicationConfiguration;
import ru.lexkml.spring.database.pool.ConnectionPool;
import ru.lexkml.spring.database.repository.CrudRepository;
import ru.lexkml.spring.database.repository.UserRepository;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            var maybeCompany = companyRepository.findById(1);

            var userRepository = context.getBean("userRepository", UserRepository.class);
//            var userRepository2 = context.getBean("userRepository2", UserRepository.class);
            var connectionPool = context.getBean("connectionPool", ConnectionPool.class);

            System.out.println(maybeCompany);
        }
    }
}
