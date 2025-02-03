package com.maxiluna.student_management.domain.usecases.career;

import com.maxiluna.student_management.domain.models.Career;

public interface GetCareerUseCase {
    Career execute(Long careerId);
}
