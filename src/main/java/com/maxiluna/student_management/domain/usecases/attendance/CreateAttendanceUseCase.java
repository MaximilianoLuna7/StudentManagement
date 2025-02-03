package com.maxiluna.student_management.domain.usecases.attendance;

import com.maxiluna.student_management.domain.models.Attendance;

public interface CreateAttendanceUseCase {
    void execute(Attendance attendance);
}
