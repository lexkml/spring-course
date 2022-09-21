package ru.lexkml.spring.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.lexkml.spring.annotation.Auditing;
import ru.lexkml.spring.annotation.Transaction;
import ru.lexkml.spring.database.entity.Company;
import ru.lexkml.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
@Transaction
@Auditing
@RequiredArgsConstructor
@Slf4j
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @Value("${db.poolSize}")
    private final Integer poolSize;

    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;

    @PostConstruct
    private void init() {
        log.info("Init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        log.info("Find by id method");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        log.info("Delete method");
    }
}
