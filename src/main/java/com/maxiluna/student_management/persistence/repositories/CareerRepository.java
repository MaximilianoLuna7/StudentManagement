package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.CareerJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CareerRepository extends JpaRepository<CareerJpa, Long> {
    Optional<CareerJpa> findByName(String name);

    boolean existsByName(String name);
}