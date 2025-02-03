package com.maxiluna.student_management.domain.usecases.subject;

import com.maxiluna.student_management.domain.models.Subject;

public interface UpdateSubjectUseCase {
    void execute(Long subjectId, Subject updatedSubject);
}
