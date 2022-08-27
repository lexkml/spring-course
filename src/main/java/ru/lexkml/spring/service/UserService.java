package ru.lexkml.spring.service;

import ru.lexkml.spring.database.repository.CompanyRepository;
import ru.lexkml.spring.database.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
