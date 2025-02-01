package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.enums.UserRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class User extends SoftDeleteEntity {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private UserRole role;

    public boolean isAdmin() {
        return this.role == UserRole.ADMIN;
    }
}