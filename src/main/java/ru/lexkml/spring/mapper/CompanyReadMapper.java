package ru.lexkml.spring.mapper;

import org.springframework.stereotype.Component;
import ru.lexkml.spring.database.entity.Company;
import ru.lexkml.spring.dto.CompanyReadDto;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {
    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(
                object.getId(),
                object.getName()
        );
    }
}
