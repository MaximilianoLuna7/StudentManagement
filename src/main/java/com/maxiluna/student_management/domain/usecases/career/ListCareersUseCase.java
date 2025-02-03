package com.maxiluna.student_management.domain.usecases.career;

import com.maxiluna.student_management.domain.models.Career;

import java.util.List;

public interface ListCareersUseCase {
    List<Career> execute();
}
