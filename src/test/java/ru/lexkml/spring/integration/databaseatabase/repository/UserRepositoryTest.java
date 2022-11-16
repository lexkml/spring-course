package ru.lexkml.spring.integration.databaseatabase.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.lexkml.spring.annotation.IT;
import ru.lexkml.spring.database.repository.UserRepository;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void findAllBy() {
        var users = userRepository.findAllBy("%a%", "%ov%");
        System.out.println(users);
    }
}