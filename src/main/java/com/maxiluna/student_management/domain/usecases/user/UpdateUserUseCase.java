package com.maxiluna.student_management.domain.usecases.user;

import com.maxiluna.student_management.domain.models.User;

public interface UpdateUserUseCase {
    void execute(Long userId, User updatedUser);
}
