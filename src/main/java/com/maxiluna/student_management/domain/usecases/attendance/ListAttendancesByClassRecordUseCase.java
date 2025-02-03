package com.maxiluna.student_management.domain.usecases.attendance;

import com.maxiluna.student_management.domain.models.Attendance;

import java.util.List;

public interface ListAttendancesByClassRecordUseCase {
    List<Attendance> execute(Long classRecordId);
}
