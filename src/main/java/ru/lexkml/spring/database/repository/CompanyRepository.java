package ru.lexkml.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lexkml.spring.database.entity.Company;

import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByName(String name);

    List<Company> findByNameContainingIgnoreCase(String fragment);
}
