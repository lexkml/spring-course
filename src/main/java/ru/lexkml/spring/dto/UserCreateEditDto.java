package ru.lexkml.spring.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import ru.lexkml.spring.database.entity.Role;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String username;
//    @DateTimeFormat(pattern = "yyyy=-MM-dd")
    LocalDate birthDade;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
