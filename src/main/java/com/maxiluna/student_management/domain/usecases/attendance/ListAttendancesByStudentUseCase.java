package com.maxiluna.student_management.domain.usecases.attendance;

import com.maxiluna.student_management.domain.models.Attendance;

import java.util.List;

public interface ListAttendancesByStudentUseCase {
    List<Attendance> execute(Long studentId);
}
