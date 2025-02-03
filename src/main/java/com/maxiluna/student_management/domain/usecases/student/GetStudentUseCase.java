package com.maxiluna.student_management.domain.usecases.student;

import com.maxiluna.student_management.domain.models.Student;

public interface GetStudentUseCase {
    Student execute(Long studentId);
}
