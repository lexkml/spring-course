package ru.lexkml.spring.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@Value
@ConstructorBinding
@ConfigurationProperties(prefix = "eb")
public class DatabaseProperties {

    String user;
    String username;
    String password;
    String url;
    Integer poolSize;
    List<PoolProperties> pools;

    @Value
    public static class PoolProperties {
        Integer size;
        Integer timeout;
    }
}
