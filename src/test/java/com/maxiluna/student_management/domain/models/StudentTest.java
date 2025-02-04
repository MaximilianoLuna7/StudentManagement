package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class StudentTest {

    private Student student;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a default Student instance before each test
        student = TestEntityFactory.createDefaultStudent();
    }

    @Test
    @DisplayName("Create Student instance")
    public void createStudent_SuccessfulInstantiation() {
        // Act & Assert: Verify that the Student instance is not null
        assertThat(student).isNotNull();
    }

    @Test
    @DisplayName("Set and get 'firstName' property - Successful")
    public void setAndGetFirstName_Successful() {
        // Arrange & Act: Set a new first name
        String newFirstName = "Jane";
        student.setFirstName(newFirstName);

        // Assert: Verify that the first name was updated correctly
        assertThat(student.getFirstName()).isEqualTo(newFirstName);
    }

    @Test
    @DisplayName("Set and get 'lastName' property - Successful")
    public void setAndGetLastName_Successful() {
        // Arrange & Act: Set a new last name
        String newLastName = "Doe";
        student.setLastName(newLastName);

        // Assert: Verify that the last name was updated correctly
        assertThat(student.getLastName()).isEqualTo(newLastName);
    }

    @Test
    @DisplayName("Set and get 'email' property - Successful")
    public void setAndGetEmail_Successful() {
        // Arrange & Act: Set a new email
        String newEmail = "jane.doe@example.com";
        student.setEmail(newEmail);

        // Assert: Verify that the email was updated correctly
        assertThat(student.getEmail()).isEqualTo(newEmail);
    }

    @Test
    @DisplayName("Set and get 'birthDate' property - Successful")
    public void setAndGetBirthDate_Successful() {
        // Arrange & Act: Set a new birth date
        LocalDate newBirthDate = LocalDate.of(2000, 5, 15);
        student.setBirthDate(newBirthDate);

        // Assert: Verify that the birth date was updated correctly
        assertThat(student.getBirthDate()).isEqualTo(newBirthDate);
    }

    @Test
    @DisplayName("Set and get 'dni' property - Successful")
    public void setAndGetDni_Successful() {
        // Arrange & Act: Set a new DNI
        String newDni = "12345678";
        student.setDni(newDni);

        // Assert: Verify that the DNI was updated correctly
        assertThat(student.getDni()).isEqualTo(newDni);
    }

    @Test
    @DisplayName("Set and get 'city' property - Successful")
    public void setAndGetCity_Successful() {
        // Arrange & Act: Set a new city
        String newCity = "New York";
        student.setCity(newCity);

        // Assert: Verify that the city was updated correctly
        assertThat(student.getCity()).isEqualTo(newCity);
    }

    @Test
    @DisplayName("Set and get 'admissionYear' property - Successful")
    public void setAndGetAdmissionYear_Successful() {
        // Arrange & Act: Set a new admission year
        Integer newAdmissionYear = 2022;
        student.setAdmissionYear(newAdmissionYear);

        // Assert: Verify that the admission year was updated correctly
        assertThat(student.getAdmissionYear()).isEqualTo(newAdmissionYear);
    }

    @Test
    @DisplayName("Verify 'isDeleted' field is initialized to false")
    public void verifyIsDeleted_InitializedToFalse() {
        // Assert: Verify that isDeleted is initialized to false by default
        assertThat(student.isDeleted()).isFalse();
    }

    @Test
    @DisplayName("Deactivate Student and verify 'isDeleted' status")
    public void deactivateStudent_VerifyIsDeletedStatus() {
        // Act: Deactivate the student
        student.deactivate();

        // Assert: Verify that isDeleted is true after deactivation
        assertThat(student.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Equality test for Student instances")
    public void equalityTest() {
        // Arrange: Create a second Student instance with the same attributes
        Student equalStudent = TestEntityFactory.createDefaultStudent();

        // Act & Assert: Verify that both instances are equal
        assertThat(student).isEqualTo(equalStudent);
    }

    @Test
    @DisplayName("Equality test for Student instances with different isDeleted values")
    public void equalityTest_SameAttributesDifferentIsDeleted() {
        // Arrange: Create a second Student instance with the same attributes but deactivate it
        Student equalStudent = TestEntityFactory.createDefaultStudent();
        equalStudent.deactivate(); // Set isDeleted to true

        // Act & Assert: Verify that both instances are not considered equal
        assertThat(student).isNotEqualTo(equalStudent);

        // Additional Assertion: Verify that isDeleted is different
        assertThat(student.isDeleted()).isFalse();
        assertThat(equalStudent.isDeleted()).isTrue();
    }
}