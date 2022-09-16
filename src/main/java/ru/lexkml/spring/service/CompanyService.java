package ru.lexkml.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.lexkml.spring.database.entity.Company;
import ru.lexkml.spring.database.repository.CrudRepository;
import ru.lexkml.spring.dto.CompanyReadDto;
import ru.lexkml.spring.listener.entity.AccessType;
import ru.lexkml.spring.listener.entity.EntityEvent;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;


    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(company -> {
                    eventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
                    return new CompanyReadDto(company.id());
                });
    }
}
