package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentJpa, Long> {
    Optional<StudentJpa> findByEmail(String email);

    boolean existsByEmail(String email);

    List<StudentJpa> findByAdmissionYear(Integer admissionYear);
}