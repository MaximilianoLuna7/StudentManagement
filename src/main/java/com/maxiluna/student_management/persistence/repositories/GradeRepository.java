package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.GradeJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<GradeJpa, Long> {
    List<GradeJpa> findByClassRecordId(Long classRecordId);

    List<GradeJpa> findByStudentId(Long studentId);
}