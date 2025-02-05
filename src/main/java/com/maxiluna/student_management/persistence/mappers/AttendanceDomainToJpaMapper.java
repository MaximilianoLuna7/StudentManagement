package com.maxiluna.student_management.persistence.mappers;

import com.maxiluna.student_management.domain.models.Attendance;
import com.maxiluna.student_management.persistence.entities.AttendanceJpa;
import com.maxiluna.student_management.persistence.entities.ClassRecordJpa;
import com.maxiluna.student_management.persistence.entities.StudentJpa;

public class AttendanceDomainToJpaMapper {

    /**
     * Converts an AttendanceJpa entity to an Attendance domain entity.
     */
    public static Attendance toDomain(AttendanceJpa attendanceJpa) {
        if (attendanceJpa == null) {
            return null;
        }
        return Attendance.builder()
                .id(attendanceJpa.getId())
                .dateRecord(attendanceJpa.getDateRecord())
                .student(StudentDomainToJpaMapper.toDomain(attendanceJpa.getStudent()))
                .classRecord(ClassRecordDomainToJpaMapper.toDomain(attendanceJpa.getClassRecord()))
                .attendanceStatus(attendanceJpa.getAttendanceStatus())
                .build();
    }

    /**
     * Converts an Attendance domain entity to an AttendanceJpa entity.
     */
    public static AttendanceJpa toJpa(Attendance attendance) {
        if (attendance == null) {
            return null;
        }
        return AttendanceJpa.builder()
                .id(attendance.getId())
                .dateRecord(attendance.getDateRecord())
                .student(StudentDomainToJpaMapper.toJpa(attendance.getStudent()))
                .classRecord(ClassRecordDomainToJpaMapper.toJpa(attendance.getClassRecord()))
                .attendanceStatus(attendance.getAttendanceStatus())
                .isDeleted(false) // New entities are not deleted by default
                .build();
    }
}