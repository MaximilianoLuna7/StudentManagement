package com.maxiluna.student_management.persistence.mappers;

import com.maxiluna.student_management.domain.models.Grade;
import com.maxiluna.student_management.persistence.entities.ClassRecordJpa;
import com.maxiluna.student_management.persistence.entities.GradeJpa;
import com.maxiluna.student_management.persistence.entities.StudentJpa;
import com.maxiluna.student_management.persistence.entities.SubjectJpa;

public class GradeDomainToJpaMapper {

    /**
     * Converts a GradeJpa entity to a Grade domain entity.
     */
    public static Grade toDomain(GradeJpa gradeJpa) {
        if (gradeJpa == null) {
            return null;
        }
        return Grade.builder()
                .id(gradeJpa.getId())
                .recordDate(gradeJpa.getRecordDate())
                .description(gradeJpa.getDescription())
                .score(gradeJpa.getScore())
                .subject(SubjectDomainToJpaMapper.toDomain(gradeJpa.getSubject()))
                .student(StudentDomainToJpaMapper.toDomain(gradeJpa.getStudent()))
                .classRecord(ClassRecordDomainToJpaMapper.toDomain(gradeJpa.getClassRecord()))
                .build();
    }

    /**
     * Converts a Grade domain entity to a GradeJpa entity.
     */
    public static GradeJpa toJpa(Grade grade) {
        if (grade == null) {
            return null;
        }
        return GradeJpa.builder()
                .id(grade.getId())
                .recordDate(grade.getRecordDate())
                .description(grade.getDescription())
                .score(grade.getScore())
                .subject(SubjectDomainToJpaMapper.toJpa(grade.getSubject()))
                .student(StudentDomainToJpaMapper.toJpa(grade.getStudent()))
                .classRecord(ClassRecordDomainToJpaMapper.toJpa(grade.getClassRecord()))
                .isDeleted(false) // New entities are not deleted by default
                .build();
    }
}