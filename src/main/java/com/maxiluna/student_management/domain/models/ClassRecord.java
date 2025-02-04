package com.maxiluna.student_management.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClassRecord extends SoftDeleteEntity {
    private Long id;
    private String topic;
    private String activities;
    private LocalDate date;
    private Subject subject;
}
