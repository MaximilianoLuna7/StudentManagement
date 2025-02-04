package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.domain.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a default User instance before each test
        user = TestEntityFactory.createDefaultUser();
    }

    @Test
    @DisplayName("Create User instance")
    public void createUser_SuccessfulInstantiation() {
        // Act & Assert: Verify that the User instance is not null
        assertThat(user).isNotNull();
    }

    @Test
    @DisplayName("Verify 'isDeleted' field is initialized to false")
    public void verifyIsDeleted_InitializedToFalse() {
        // Assert: Verify that isDeleted is initialized to false by default
        assertThat(user.isDeleted()).isFalse();
    }

    @Test
    @DisplayName("Deactivate User and verify 'isDeleted' status")
    public void deactivateUser_VerifyIsDeletedStatus() {
        // Act: Deactivate the user
        user.deactivate();

        // Assert: Verify that isDeleted is true after deactivation
        assertThat(user.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Set and get 'email' property - Successful")
    public void setAndGetEmail_Successful() {
        // Arrange & Act: Set a new email
        String newEmail = "new.email@example.com";
        user.setEmail(newEmail);

        // Assert: Verify that the email was updated correctly
        assertThat(user.getEmail()).isEqualTo(newEmail);
    }

    @Test
    @DisplayName("Set and get 'firstName' property - Successful")
    public void setAndGetFirstName_Successful() {
        // Arrange & Act: Set a new first name
        String newFirstName = "Jane";
        user.setFirstName(newFirstName);

        // Assert: Verify that the first name was updated correctly
        assertThat(user.getFirstName()).isEqualTo(newFirstName);
    }

    @Test
    @DisplayName("Set and get 'lastName' property - Successful")
    public void setAndGetLastName_Successful() {
        // Arrange & Act: Set a new last name
        String newLastName = "Smith";
        user.setLastName(newLastName);

        // Assert: Verify that the last name was updated correctly
        assertThat(user.getLastName()).isEqualTo(newLastName);
    }

    @Test
    @DisplayName("Set and get 'password' property - Successful")
    public void setAndGetPassword_Successful() {
        // Arrange & Act: Set a new password
        String newPassword = "newPassword456";
        user.setPassword(newPassword);

        // Assert: Verify that the password was updated correctly
        assertThat(user.getPassword()).isEqualTo(newPassword);
    }

    @Test
    @DisplayName("Set and get 'birthDate' property - Successful")
    public void setAndGetBirthDate_Successful() {
        // Arrange & Act: Set a new birth date
        LocalDate newBirthDate = LocalDate.of(1990, 5, 15);
        user.setBirthDate(newBirthDate);

        // Assert: Verify that the birth date was updated correctly
        assertThat(user.getBirthDate()).isEqualTo(newBirthDate);
    }

    @Test
    @DisplayName("Set and get 'role' property - Successful")
    public void setAndGetRole_Successful() {
        // Arrange & Act: Set a new role
        UserRole newRole = UserRole.TEACHER;
        user.setRole(newRole);

        // Assert: Verify that the role was updated correctly
        assertThat(user.getRole()).isEqualTo(newRole);
    }

    @Test
    @DisplayName("Check isAdmin() method for ADMIN role")
    public void isAdmin_UserIsAdmin_ReturnsTrue() {
        // Arrange: Set the role to ADMIN
        user.setRole(UserRole.ADMIN);

        // Act & Assert: Verify that isAdmin() returns true
        assertThat(user.isAdmin()).isTrue();
    }

    @Test
    @DisplayName("Check isAdmin() method for non-ADMIN role")
    public void isAdmin_UserIsNotAdmin_ReturnsFalse() {
        // Arrange: Set the role to TEACHER
        user.setRole(UserRole.TEACHER);

        // Act & Assert: Verify that isAdmin() returns false
        assertThat(user.isAdmin()).isFalse();
    }

    @Test
    @DisplayName("Equality test for User instances")
    public void equalityTest() {
        // Arrange: Create a second User instance with the same attributes
        User equalUser = TestEntityFactory.createUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getRole()
        );

        // Act & Assert: Verify that both instances are equal
        assertThat(user).isEqualTo(equalUser);
    }

    @Test
    @DisplayName("Equality test for User instances with same attributes but different isDeleted values")
    public void equalityTest_SameAttributesDifferentIsDeleted() {
        // Arrange: Create a second User instance with the same attributes but deactivate it
        User equalUser = TestEntityFactory.createUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getRole()
        );
        equalUser.deactivate(); // Set isDeleted to true

        // Act & Assert: Verify that both instances are not considered equal
        assertThat(user).isNotEqualTo(equalUser);

        // Additional Assertion: Verify that isDeleted is different
        assertThat(user.isDeleted()).isFalse();
        assertThat(equalUser.isDeleted()).isTrue();
    }
}
