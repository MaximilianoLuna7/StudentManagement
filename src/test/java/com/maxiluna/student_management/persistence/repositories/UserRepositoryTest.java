package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.persistence.entities.UserJpa;
import com.maxiluna.student_management.persistence.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestEntityFactory.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityFactory testEntityFactory;

    private UserJpa user;

    @BeforeEach
    void setUp() {
        // Arrange: Create and save a default user before each test
        user = testEntityFactory.createAndSaveUser(
                "test@example.com",
                "password123",
                "John",
                "Doe",
                LocalDate.of(1990, 1, 1),
                UserRole.ADMIN
        );
    }

    @Test
    @DisplayName("Save and retrieve a user")
    void saveAndRetrieveUser_Successful() {
        // Act: Retrieve the user by ID
        Optional<UserJpa> foundUser = userRepository.findById(user.getId());

        // Assert: Verify that the user can be retrieved by ID
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    @DisplayName("Find user by email")
    void findByEmail_Successful() {
        // Act: Retrieve the user by email
        Optional<UserJpa> foundUser = userRepository.findByEmail(user.getEmail());

        // Assert: Verify that the user can be retrieved by email
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getFirstName()).isEqualTo(user.getFirstName());
    }

    @Test
    @DisplayName("Check if email exists")
    void existsByEmail_Successful() {
        // Act: Check if the email exists
        boolean exists = userRepository.existsByEmail(user.getEmail());

        // Assert: Verify that the email exists in the database
        assertThat(exists).isTrue();
    }

    @Test
    @DisplayName("Delete a user")
    void deleteUser_Successful() {
        // Act: Delete the user
        userRepository.delete(user);

        // Assert: Verify that the user is no longer in the database
        Optional<UserJpa> deletedUser = userRepository.findById(user.getId());
        assertThat(deletedUser).isEmpty();
    }
}