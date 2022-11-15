package ru.lexkml.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lexkml.spring.database.repository.CompanyRepository;
import ru.lexkml.spring.dto.CompanyReadDto;
import ru.lexkml.spring.listener.entity.AccessType;
import ru.lexkml.spring.listener.entity.EntityEvent;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(company -> {
                    eventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
                    return new CompanyReadDto(company.getId());
                });
    }
}
