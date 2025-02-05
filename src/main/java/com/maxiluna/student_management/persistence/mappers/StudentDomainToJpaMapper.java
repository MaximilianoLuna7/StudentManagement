package com.maxiluna.student_management.persistence.mappers;

import com.maxiluna.student_management.domain.models.Student;
import com.maxiluna.student_management.persistence.entities.StudentJpa;

public class StudentDomainToJpaMapper {

    /**
     * Converts a StudentJpa entity to a Student domain entity.
     */
    public static Student toDomain(StudentJpa studentJpa) {
        if (studentJpa == null) {
            return null;
        }
        return Student.builder()
                .id(studentJpa.getId())
                .firstName(studentJpa.getFirstName())
                .lastName(studentJpa.getLastName())
                .email(studentJpa.getEmail())
                .birthDate(studentJpa.getBirthDate())
                .dni(studentJpa.getDni())
                .city(studentJpa.getCity())
                .admissionYear(studentJpa.getAdmissionYear())
                .build();
    }

    /**
     * Converts a Student domain entity to a StudentJpa entity.
     */
    public static StudentJpa toJpa(Student student) {
        if (student == null) {
            return null;
        }
        return StudentJpa.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .birthDate(student.getBirthDate())
                .dni(student.getDni())
                .city(student.getCity())
                .admissionYear(student.getAdmissionYear())
                .isDeleted(false) // New entities are not deleted by default
                .build();
    }
}