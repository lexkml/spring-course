package ru.lexkml.spring.database.repository;

import org.springframework.data.repository.CrudRepository;
import ru.lexkml.spring.database.entity.Company;

import java.util.Optional;


public interface CompanyRepository extends CrudRepository<Company, Integer> {
    Optional<Company> findById(Integer id);
    void delete(Company entity);
}
