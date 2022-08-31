package ru.lexkml.spring.database.repository;

import org.springframework.stereotype.Repository;
import ru.lexkml.spring.database.pool.ConnectionPool;

@Repository
public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
