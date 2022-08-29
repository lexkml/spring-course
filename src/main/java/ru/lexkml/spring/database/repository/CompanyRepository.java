package ru.lexkml.spring.database.repository;

import ru.lexkml.spring.annotation.Auditing;
import ru.lexkml.spring.annotation.InjectBean;
import ru.lexkml.spring.annotation.Transaction;
import ru.lexkml.spring.database.entity.Company;
import ru.lexkml.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init() {
        System.out.println("Init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("Find by id method");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("Delete method");
    }
}
