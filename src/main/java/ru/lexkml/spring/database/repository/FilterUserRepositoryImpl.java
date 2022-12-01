package ru.lexkml.spring.database.repository;

import lombok.RequiredArgsConstructor;
import ru.lexkml.spring.database.entity.User;
import ru.lexkml.spring.dto.UserFilter;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager entityManager;

    @Override
    public List<User> findAllByFilter(UserFilter userFilter) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteria = criteriaBuilder.createQuery(User.class);
        var user = criteria.from(User.class);

        criteria.select(user);

        List<Predicate> predicates = new ArrayList<>();
        if (userFilter.firstname() != null) {
            predicates.add(criteriaBuilder.like(user.get("firstname"), userFilter.firstname()));
        }
        if (userFilter.lastname() != null) {
            predicates.add(criteriaBuilder.like(user.get("lastname"), userFilter.lastname()));
        }
        if (userFilter.birthDate() != null) {
            predicates.add(criteriaBuilder.lessThan(user.get("birthDate"), userFilter.birthDate()));
        }

        criteria.where(predicates.toArray(Predicate[]::new));

        return entityManager.createQuery(criteria).getResultList();
    }
}
