package ru.lexkml.spring.database.pool;

import java.util.List;
import java.util.Map;

public class ConnectionPool {
    private final String user;
    private final Integer poolSize;
    private final List<Object> arguments;
    private final Map<String, Object> properties;

    public ConnectionPool(String user, Integer poolSize, List<Object> arguments, Map<String, Object> properties) {
        this.user = user;
        this.poolSize = poolSize;
        this.arguments = arguments;
        this.properties = properties;
    }
}
