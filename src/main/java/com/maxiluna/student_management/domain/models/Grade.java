package com.maxiluna.student_management.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Grade extends SoftDeleteEntity {
    private Long id;
    private LocalDate recordDate;
    private String description;
    private Double score;
    private Subject subject;
    private Student student;
    private ClassRecord classRecord;
}