package com.maxiluna.student_management.domain.usecases.career;

import com.maxiluna.student_management.domain.models.Career;

public interface UpdateCareerUseCase {
    void execute(Long careerId, Career updatedCareer);
}
