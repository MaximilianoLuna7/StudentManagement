package com.maxiluna.student_management.persistence.mappers;

import com.maxiluna.student_management.domain.models.Subject;
import com.maxiluna.student_management.persistence.entities.CareerJpa;
import com.maxiluna.student_management.persistence.entities.SubjectJpa;
import com.maxiluna.student_management.persistence.entities.UserJpa;

public class SubjectDomainToJpaMapper {

    /**
     * Converts a SubjectJpa entity to a Subject domain entity.
     */
    public static Subject toDomain(SubjectJpa subjectJpa) {
        if (subjectJpa == null) {
            return null;
        }
        return Subject.builder()
                .id(subjectJpa.getId())
                .name(subjectJpa.getName())
                .academicYear(subjectJpa.getAcademicYear())
                .career(CareerDomainToJpaMapper.toDomain(subjectJpa.getCareer()))
                .teacher(UserDomainToJpaMapper.toDomain(subjectJpa.getTeacher()))
                .build();
    }

    /**
     * Converts a Subject domain entity to a SubjectJpa entity.
     */
    public static SubjectJpa toJpa(Subject subject) {
        if (subject == null) {
            return null;
        }
        return SubjectJpa.builder()
                .id(subject.getId())
                .name(subject.getName())
                .academicYear(subject.getAcademicYear())
                .career(CareerDomainToJpaMapper.toJpa(subject.getCareer()))
                .teacher(UserDomainToJpaMapper.toJpa(subject.getTeacher()))
                .isDeleted(false) // New entities are not deleted by default
                .build();
    }
}