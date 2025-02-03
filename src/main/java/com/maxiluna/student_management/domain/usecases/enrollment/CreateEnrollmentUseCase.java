package com.maxiluna.student_management.domain.usecases.enrollment;

import com.maxiluna.student_management.domain.models.Enrollment;

public interface CreateEnrollmentUseCase {
    void execute(Enrollment enrollment);
}
