package ru.lexkml.spring.database.pool;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("pool1")
@RequiredArgsConstructor
public class ConnectionPool {

    @Value("${db.user}")
    private final String user;
    @Value("${db.poolSize}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        System.out.println("Initialization connection pool in initialization method");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool in destroy method");
    }
}
