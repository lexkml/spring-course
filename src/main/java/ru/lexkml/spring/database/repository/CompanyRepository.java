package ru.lexkml.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.lexkml.spring.database.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c " +
            "join fetch c.locales cl " +
            "where lower(c.name) = lower(:name)")
    Optional<Company> findByName(String name);

    List<Company> findByNameContainingIgnoreCase(String fragment);
}
