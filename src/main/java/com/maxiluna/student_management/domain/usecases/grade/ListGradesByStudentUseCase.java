package com.maxiluna.student_management.domain.usecases.grade;

import com.maxiluna.student_management.domain.models.Grade;

import java.util.List;

public interface ListGradesByStudentUseCase {
    List<Grade> execute(Long studentId);
}
