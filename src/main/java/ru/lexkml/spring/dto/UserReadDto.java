package ru.lexkml.spring.dto;

import lombok.Value;
import ru.lexkml.spring.database.entity.Role;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Long id;
    String username;
    LocalDate birthDade;
    String firstname;
    String lastname;
    Role role;
    CompanyReadDto company;
}
