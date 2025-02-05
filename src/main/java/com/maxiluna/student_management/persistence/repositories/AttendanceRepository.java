package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.AttendanceJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceJpa, Long> {
    List<AttendanceJpa> findByClassRecordId(Long classRecordId);

    List<AttendanceJpa> findByStudentId(Long studentId);
}