package ru.lexkml.spring.database.repository;

import ru.lexkml.spring.database.entity.Role;
import ru.lexkml.spring.database.entity.User;
import ru.lexkml.spring.dto.PersonalInfo;
import ru.lexkml.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
