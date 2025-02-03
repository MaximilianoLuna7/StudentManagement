package com.maxiluna.student_management.domain.usecases.student;

import com.maxiluna.student_management.domain.models.Student;

public interface CreateStudentUseCase {
    void execute(Student student);
}
