package ru.lexkml.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lexkml.spring.database.pool.ConnectionPool;
import ru.lexkml.spring.database.repository.CompanyRepository;

public class ApplicationRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");

        var companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        
        var connectionPoolBean = context.getBean("connectionPoolBean", ConnectionPool.class);
        var connectionPoolBean2 = context.getBean("connectionPoolBean", ConnectionPool.class);
        var connectionPoolBean3 = context.getBean("connectionPoolBean", ConnectionPool.class);

        System.out.println();
    }
}
