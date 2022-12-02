package ru.lexkml.spring.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import ru.lexkml.spring.database.entity.Role;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String username;
    LocalDate birthDade;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
