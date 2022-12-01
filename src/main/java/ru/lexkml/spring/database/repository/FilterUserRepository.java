package ru.lexkml.spring.database.repository;

import ru.lexkml.spring.database.entity.User;
import ru.lexkml.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter userFilter);
}
