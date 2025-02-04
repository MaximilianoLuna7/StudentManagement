package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.enums.StudentStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Enrollment extends SoftDeleteEntity {
    private Long id;
    private Student student;
    private Subject subject;
    private StudentStatus studentStatus;
}
