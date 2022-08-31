package ru.lexkml.spring.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.lexkml.spring.annotation.Auditing;
import ru.lexkml.spring.annotation.Transaction;
import ru.lexkml.spring.database.entity.Company;
import ru.lexkml.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @Autowired
    private ConnectionPool connectionPoolBean2;
    @Autowired
    private List<ConnectionPool> pools;
    @Value("${db.poolSize}")
    private Integer poolSize;

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
