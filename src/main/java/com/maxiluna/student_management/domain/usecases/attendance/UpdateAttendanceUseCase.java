package com.maxiluna.student_management.domain.usecases.attendance;

import com.maxiluna.student_management.domain.models.Attendance;

public interface UpdateAttendanceUseCase {
    void execute(Long attendanceId, Attendance updatedAttendance);
}
