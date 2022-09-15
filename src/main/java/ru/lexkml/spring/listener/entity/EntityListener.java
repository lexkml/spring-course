package ru.lexkml.spring.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener
    public void acceptEntity(EntityEvent entityEvent) {
        System.out.printf("Entity: " + entityEvent);
    }

}
