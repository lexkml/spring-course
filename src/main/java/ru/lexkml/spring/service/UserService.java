package ru.lexkml.spring.service;

import ru.lexkml.spring.database.repository.CompanyRepository;
import ru.lexkml.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
}
