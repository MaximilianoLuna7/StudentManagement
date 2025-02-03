package com.maxiluna.student_management.domain.usecases.student;

import com.maxiluna.student_management.domain.models.Student;

import java.util.List;

public interface ListStudentsUseCase {
    List<Student> execute();
}
