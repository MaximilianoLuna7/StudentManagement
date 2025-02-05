package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.SubjectJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectJpa, Long> {
    Optional<SubjectJpa> findByName(String name);

    List<SubjectJpa> findByCareerId(Long careerId);

    List<SubjectJpa> findByTeacherId(Long teacherId);

    boolean existsByName(String name);
}