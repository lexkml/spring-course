package ru.lexkml.spring.config;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.lexkml.spring.condition.JpaCondition;

import javax.annotation.PostConstruct;

@Configuration
@Conditional(JpaCondition.class)
public class JpaConfiguration {

    @PostConstruct
    void init() {
        System.out.println("Jpa configuration is enabled!");
    }
}
