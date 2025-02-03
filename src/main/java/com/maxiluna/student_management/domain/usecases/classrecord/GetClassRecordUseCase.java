package com.maxiluna.student_management.domain.usecases.classrecord;

import com.maxiluna.student_management.domain.models.ClassRecord;

public interface GetClassRecordUseCase {
    ClassRecord execute(Long classRecordId);
}
