package com.maxiluna.student_management.domain.usecases.user;

public interface LoginUserUseCase {
    String execute(String email, String password);
}
