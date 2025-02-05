package com.maxiluna.student_management.persistence.mappers;

import com.maxiluna.student_management.domain.models.Enrollment;
import com.maxiluna.student_management.persistence.entities.EnrollmentJpa;
import com.maxiluna.student_management.persistence.entities.StudentJpa;
import com.maxiluna.student_management.persistence.entities.SubjectJpa;

public class EnrollmentDomainToJpaMapper {

    /**
     * Converts an EnrollmentJpa entity to an Enrollment domain entity.
     */
    public static Enrollment toDomain(EnrollmentJpa enrollmentJpa) {
        if (enrollmentJpa == null) {
            return null;
        }
        return Enrollment.builder()
                .id(enrollmentJpa.getId())
                .student(StudentDomainToJpaMapper.toDomain(enrollmentJpa.getStudent()))
                .subject(SubjectDomainToJpaMapper.toDomain(enrollmentJpa.getSubject()))
                .studentStatus(enrollmentJpa.getStudentStatus())
                .build();
    }

    /**
     * Converts an Enrollment domain entity to an EnrollmentJpa entity.
     */
    public static EnrollmentJpa toJpa(Enrollment enrollment) {
        if (enrollment == null) {
            return null;
        }
        return EnrollmentJpa.builder()
                .id(enrollment.getId())
                .student(StudentDomainToJpaMapper.toJpa(enrollment.getStudent()))
                .subject(SubjectDomainToJpaMapper.toJpa(enrollment.getSubject()))
                .studentStatus(enrollment.getStudentStatus())
                .isDeleted(false) // New entities are not deleted by default
                .build();
    }
}