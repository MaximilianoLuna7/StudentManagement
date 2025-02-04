package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.enums.StudentStatus;
import com.maxiluna.student_management.domain.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnrollmentTest {

    private Enrollment enrollment;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a default Enrollment instance before each test
        Student student = TestEntityFactory.createDefaultStudent();
        Subject subject = TestEntityFactory.createDefaultSubject();
        enrollment = TestEntityFactory.createEnrollment(
                1L,
                student,
                subject,
                StudentStatus.REGULAR
        );
    }

    @Test
    @DisplayName("Create Enrollment instance")
    public void createEnrollment_SuccessfulInstantiation() {
        // Act & Assert: Verify that the Enrollment instance is not null
        assertThat(enrollment).isNotNull();
    }

    @Test
    @DisplayName("Set and get 'student' property - Successful")
    public void setAndGetStudent_Successful() {
        // Arrange & Act: Set a new student
        Student newStudent = TestEntityFactory.createDefaultStudent();
        enrollment.setStudent(newStudent);

        // Assert: Verify that the student was updated correctly
        assertThat(enrollment.getStudent()).isEqualTo(newStudent);
    }

    @Test
    @DisplayName("Set and get 'subject' property - Successful")
    public void setAndGetSubject_Successful() {
        // Arrange & Act: Set a new subject
        Subject newSubject = TestEntityFactory.createDefaultSubject();
        enrollment.setSubject(newSubject);

        // Assert: Verify that the subject was updated correctly
        assertThat(enrollment.getSubject()).isEqualTo(newSubject);
    }

    @Test
    @DisplayName("Set and get 'studentStatus' property - Successful")
    public void setAndGetStudentStatus_Successful() {
        // Arrange & Act: Set a new student status
        StudentStatus newStatus = StudentStatus.APPROVED;
        enrollment.setStudentStatus(newStatus);

        // Assert: Verify that the student status was updated correctly
        assertThat(enrollment.getStudentStatus()).isEqualTo(newStatus);
    }

    @Test
    @DisplayName("Verify 'isDeleted' field is initialized to false")
    public void verifyIsDeleted_InitializedToFalse() {
        // Assert: Verify that isDeleted is initialized to false by default
        assertThat(enrollment.isDeleted()).isFalse();
    }

    @Test
    @DisplayName("Deactivate Enrollment and verify 'isDeleted' status")
    public void deactivateEnrollment_VerifyIsDeletedStatus() {
        // Act: Deactivate the enrollment
        enrollment.deactivate();

        // Assert: Verify that isDeleted is true after deactivation
        assertThat(enrollment.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Equality test for Enrollment instances")
    public void equalityTest() {
        // Arrange: Create a second Enrollment instance with the same attributes
        Student student = TestEntityFactory.createDefaultStudent();
        Subject subject = TestEntityFactory.createDefaultSubject();
        Enrollment equalEnrollment = TestEntityFactory.createEnrollment(
                enrollment.getId(),
                student,
                subject,
                enrollment.getStudentStatus()
        );

        // Act & Assert: Verify that both instances are equal
        assertThat(enrollment).isEqualTo(equalEnrollment);
    }

    @Test
    @DisplayName("Equality test for Enrollment instances with different isDeleted values")
    public void equalityTest_SameAttributesDifferentIsDeleted() {
        // Arrange: Create a second Enrollment instance with the same attributes but deactivate it
        Student student = TestEntityFactory.createDefaultStudent();
        Subject subject = TestEntityFactory.createDefaultSubject();
        Enrollment equalEnrollment = TestEntityFactory.createEnrollment(
                enrollment.getId(),
                student,
                subject,
                enrollment.getStudentStatus()
        );
        equalEnrollment.deactivate(); // Set isDeleted to true

        // Act & Assert: Verify that both instances are not considered equal
        assertThat(enrollment).isNotEqualTo(equalEnrollment);

        // Additional Assertion: Verify that isDeleted is different
        assertThat(enrollment.isDeleted()).isFalse();
        assertThat(equalEnrollment.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Verify relationships with Student and Subject")
    public void verifyRelationships() {
        // Arrange: Get the related entities
        Student student = TestEntityFactory.createDefaultStudent();
        Subject subject = TestEntityFactory.createDefaultSubject();

        // Act: Set the relationships
        enrollment.setStudent(student);
        enrollment.setSubject(subject);

        // Assert: Verify that the relationships were set correctly
        assertThat(enrollment.getStudent()).isEqualTo(student);
        assertThat(enrollment.getSubject()).isEqualTo(subject);
    }
}