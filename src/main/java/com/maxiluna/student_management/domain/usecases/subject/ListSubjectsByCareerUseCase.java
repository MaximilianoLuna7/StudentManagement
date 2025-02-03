package com.maxiluna.student_management.domain.usecases.subject;

import com.maxiluna.student_management.domain.models.Subject;

import java.util.List;

public interface ListSubjectsByCareerUseCase {
    List<Subject> execute(Long careerId);
}
