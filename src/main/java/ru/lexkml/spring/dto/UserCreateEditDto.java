package ru.lexkml.spring.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import ru.lexkml.spring.database.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {

    @Email
    String username;

    //    @DateTimeFormat(pattern = "yyyy=-MM-dd")
    LocalDate birthDade;

    @NotNull
    @Size(min = 3, max = 64)
    String firstname;

    @NotNull
    String lastname;

    Role role;

    Integer companyId;
}
