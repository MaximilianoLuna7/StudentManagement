package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.ClassRecordJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRecordRepository extends JpaRepository<ClassRecordJpa, Long> {
    List<ClassRecordJpa> findBySubjectId(Long subjectId);
}