package com.maxiluna.student_management.domain.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Subject extends SoftDeleteEntity {
    private Long id;
    private String name;
    private Integer academicYear;
    private Career career;
    private User teacher;
}
