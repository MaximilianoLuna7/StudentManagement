package com.maxiluna.student_management.domain.usecases.user;

import com.maxiluna.student_management.domain.enums.UserRole;

public interface UpdateUserRoleUseCase {
    void execute(Long userId, UserRole newRole);
}
