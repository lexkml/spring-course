package ru.lexkml.spring.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.lexkml.spring.annotation.IT;
import ru.lexkml.spring.service.UserService;

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final UserService userService;

    @Test
    void findById() {

    }
}
