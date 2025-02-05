package com.maxiluna.student_management.persistence.mappers;

import com.maxiluna.student_management.domain.models.User;
import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.persistence.entities.UserJpa;

public class UserDomainToJpaMapper {

    /**
     * Converts a UserJpa entity to a User domain entity.
     * Ignores the 'isDeleted' field because it should be managed explicitly in the service layer.
     */
    public static User toDomain(UserJpa userJpa) {
        if (userJpa == null) {
            return null;
        }
        return User.builder()
                .id(userJpa.getId())
                .email(userJpa.getEmail())
                .password(userJpa.getPassword())
                .firstName(userJpa.getFirstName())
                .lastName(userJpa.getLastName())
                .birthDate(userJpa.getBirthDate())
                .role(userJpa.getRole())
                .build();
    }

    /**
     * Converts a User domain entity to a UserJpa entity.
     * Sets 'isDeleted' to false by default because new entities are not deleted.
     */
    public static UserJpa toJpa(User user) {
        if (user == null) {
            return null;
        }
        return UserJpa.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .role(user.getRole())
                .isDeleted(false) // New entities are not deleted by default
                .build();
    }
}