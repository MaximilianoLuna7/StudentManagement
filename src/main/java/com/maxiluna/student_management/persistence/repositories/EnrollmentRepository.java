package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.EnrollmentJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentJpa, Long> {
    Optional<EnrollmentJpa> findByStudentIdAndSubjectId(Long studentId, Long subjectId);

    List<EnrollmentJpa> findByStudentId(Long studentId);
}