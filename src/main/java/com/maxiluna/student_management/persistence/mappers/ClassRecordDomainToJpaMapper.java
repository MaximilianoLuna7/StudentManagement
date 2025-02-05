package com.maxiluna.student_management.persistence.mappers;

import com.maxiluna.student_management.domain.models.ClassRecord;
import com.maxiluna.student_management.persistence.entities.ClassRecordJpa;
import com.maxiluna.student_management.persistence.entities.SubjectJpa;

public class ClassRecordDomainToJpaMapper {

    /**
     * Converts a ClassRecordJpa entity to a ClassRecord domain entity.
     */
    public static ClassRecord toDomain(ClassRecordJpa classRecordJpa) {
        if (classRecordJpa == null) {
            return null;
        }
        return ClassRecord.builder()
                .id(classRecordJpa.getId())
                .topic(classRecordJpa.getTopic())
                .activities(classRecordJpa.getActivities())
                .date(classRecordJpa.getDate())
                .subject(SubjectDomainToJpaMapper.toDomain(classRecordJpa.getSubject()))
                .build();
    }

    /**
     * Converts a ClassRecord domain entity to a ClassRecordJpa entity.
     */
    public static ClassRecordJpa toJpa(ClassRecord classRecord) {
        if (classRecord == null) {
            return null;
        }
        return ClassRecordJpa.builder()
                .id(classRecord.getId())
                .topic(classRecord.getTopic())
                .activities(classRecord.getActivities())
                .date(classRecord.getDate())
                .subject(SubjectDomainToJpaMapper.toJpa(classRecord.getSubject()))
                .isDeleted(false) // New entities are not deleted by default
                .build();
    }
}