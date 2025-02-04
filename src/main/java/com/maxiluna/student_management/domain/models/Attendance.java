package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.enums.AttendanceStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Attendance extends SoftDeleteEntity {
    private Long id;
    private LocalDate dateRecord;
    private Student student;
    private ClassRecord classRecord;
    private AttendanceStatus attendanceStatus;
}
