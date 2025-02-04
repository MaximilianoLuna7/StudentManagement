package com.maxiluna.student_management.domain.usecases.user;

import com.maxiluna.student_management.domain.models.User;

import java.util.List;

public interface ListUsersUseCase {
    List<User> execute();
}
