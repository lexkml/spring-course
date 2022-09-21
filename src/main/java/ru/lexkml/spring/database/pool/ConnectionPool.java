package ru.lexkml.spring.database.pool;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("pool1")
@RequiredArgsConstructor
@Slf4j
public class ConnectionPool {

    @Value("${db.user}")
    private final String user;
    @Value("${db.poolSize}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        log.info("Initialization connection pool in initialization method");
    }

    @PreDestroy
    private void destroy() {
        log.info("Clean connection pool in destroy method");
    }
}
