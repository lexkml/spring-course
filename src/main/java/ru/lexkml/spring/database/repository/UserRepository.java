package ru.lexkml.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.lexkml.spring.database.entity.Role;
import ru.lexkml.spring.database.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT * FROM users u WHERE u.username = :username",
            nativeQuery = true
    )
    List<User> findAllByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("""
            update User u
            set u.role = :role
            where u.id in (:ids)
            """)
    int updateRole(Role role, Long... ids);
}
