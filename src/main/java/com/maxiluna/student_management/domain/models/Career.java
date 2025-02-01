package com.maxiluna.student_management.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Career extends SoftDeleteEntity {
    private Long id;
    private String name;
    private String institutionName;
    private Double durationInYears;
}