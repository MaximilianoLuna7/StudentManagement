package com.maxiluna.student_management.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Student extends SoftDeleteEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String dni;
    private String city;
    private Integer admissionYear;

    public int calculateAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
