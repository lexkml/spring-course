package ru.lexkml.spring.service;

import org.springframework.stereotype.Service;
import ru.lexkml.spring.database.entity.Company;
import ru.lexkml.spring.database.repository.CrudRepository;
import ru.lexkml.spring.database.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository, CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
