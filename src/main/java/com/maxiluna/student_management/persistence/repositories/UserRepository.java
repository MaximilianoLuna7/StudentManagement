package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {
    Optional<UserJpa> findByEmail(String email);

    boolean existsByEmail(String email);
}