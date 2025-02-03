package com.maxiluna.student_management.domain.usecases.grade;

import com.maxiluna.student_management.domain.models.Grade;

public interface UpdateGradeUseCase {
    void execute(Long gradeId, Grade updatedGrade);
}
