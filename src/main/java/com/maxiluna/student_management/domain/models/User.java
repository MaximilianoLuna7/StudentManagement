package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.enums.UserRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * Represents a user in the system (e.g., admin, teacher, or other user).
 * Inherits from SoftDeleteEntity to support soft deletion.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends SoftDeleteEntity {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private UserRole role;

    /**
     * Checks if the user has the ADMIN role.
     *
     * @return true if the user is an admin, false otherwise.
     */
    public boolean isAdmin() {
        return this.role == UserRole.ADMIN;
    }
}