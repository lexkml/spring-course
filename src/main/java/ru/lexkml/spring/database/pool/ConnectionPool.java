package ru.lexkml.spring.database.pool;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("pool1")
public class ConnectionPool {
    private final String user;
    private final Integer poolSize;

    public ConnectionPool(@Value("${db.user}") String user,
                          @Value("${db.poolSize}") Integer poolSize) {
        this.user = user;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        System.out.println("Initialization connection pool in initialization method");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool in destroy method");
    }
}
