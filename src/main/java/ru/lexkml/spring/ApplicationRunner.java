package ru.lexkml.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lexkml.spring.database.pool.ConnectionPool;

public class ApplicationRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");

        var connectionPool1 = context.getBean("pool", ConnectionPool.class);
        var someBean = context.getBean("someBean", String.class);

        System.out.println(connectionPool1);
    }
}
