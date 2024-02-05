package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;


public interface RoleRepository {
    Role findRoleByRole(String role);

    Role findRoleById(long id);
}
