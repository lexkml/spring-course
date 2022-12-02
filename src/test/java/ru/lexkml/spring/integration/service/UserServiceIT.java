package ru.lexkml.spring.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.lexkml.spring.database.entity.Role;
import ru.lexkml.spring.dto.UserCreateEditDto;
import ru.lexkml.spring.integration.IntegrationTestBase;
import ru.lexkml.spring.service.UserService;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase {

    private static final Long USER_1_ID = 1L;
    private static final Integer COMPANY_1_ID = 1;

    private final UserService userService;

    @Test
    void findAll() {
        var result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById() {
        var maybeUser = userService.findById(USER_1_ID);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals("Ivan", user.getFirstname()));
    }

    @Test
    void create() {
        var userDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "test",
                "test",
                Role.ADMIN,
                COMPANY_1_ID
        );
        var actualResult = userService.create(userDto);
        assertEquals(userDto.getUsername(), actualResult.getUsername());
        assertEquals(userDto.getFirstname(), actualResult.getFirstname());
        assertEquals(userDto.getLastname(), actualResult.getLastname());
        assertSame(userDto.getRole(), actualResult.getRole());
        assertEquals(userDto.getCompanyId(), actualResult.getCompany().id());
        assertEquals(userDto.getBirthDade(), actualResult.getBirthDade());
    }

    @Test
    void update() {
        var userDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "test",
                "test",
                Role.ADMIN,
                COMPANY_1_ID
        );

        var actualResult = userService.update(USER_1_ID, userDto);
        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user -> {
            assertEquals(userDto.getUsername(), user.getUsername());
            assertEquals(userDto.getFirstname(), user.getFirstname());
            assertEquals(userDto.getLastname(), user.getLastname());
            assertSame(userDto.getRole(), user.getRole());
            assertEquals(userDto.getCompanyId(), user.getCompany().id());
            assertEquals(userDto.getBirthDade(), user.getBirthDade());
        });
    }

    @Test
    void delete() {
        assertFalse(userService.delete(600L));
        assertTrue(userService.delete(USER_1_ID));
    }
}
