package ru.lexkml.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lexkml.spring.database.entity.Company;
import ru.lexkml.spring.database.repository.CrudRepository;
import ru.lexkml.spring.database.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}
