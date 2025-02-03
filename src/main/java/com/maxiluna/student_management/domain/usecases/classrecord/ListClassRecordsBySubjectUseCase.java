package com.maxiluna.student_management.domain.usecases.classrecord;

import com.maxiluna.student_management.domain.models.ClassRecord;

import java.util.List;

public interface ListClassRecordsBySubjectUseCase {
    List<ClassRecord> execute(Long subjectId);
}
