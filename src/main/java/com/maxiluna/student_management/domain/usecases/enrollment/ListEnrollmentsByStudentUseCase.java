package com.maxiluna.student_management.domain.usecases.enrollment;

import com.maxiluna.student_management.domain.models.Enrollment;

import java.util.List;

public interface ListEnrollmentsByStudentUseCase {
    List<Enrollment> execute(Long studentId);
}
