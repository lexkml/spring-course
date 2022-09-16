package ru.lexkml.spring.database.repository;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.lexkml.spring.database.pool.ConnectionPool;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserRepository {

    private final ConnectionPool connectionPool;
    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
