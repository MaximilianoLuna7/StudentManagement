package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubjectTest {

    private Subject subject;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a default Subject instance before each test
        User teacher = TestEntityFactory.createDefaultUser();
        Career career = TestEntityFactory.createDefaultCareer();
        subject = TestEntityFactory.createSubject(
                1L,
                "Mathematics",
                2023,
                career,
                teacher
        );
    }

    @Test
    @DisplayName("Create Subject instance")
    public void createSubject_SuccessfulInstantiation() {
        // Act & Assert: Verify that the Subject instance is not null
        assertThat(subject).isNotNull();
    }

    @Test
    @DisplayName("Set and get 'name' property - Successful")
    public void setAndGetName_Successful() {
        // Arrange & Act: Set a new name
        String newName = "Physics";
        subject.setName(newName);

        // Assert: Verify that the name was updated correctly
        assertThat(subject.getName()).isEqualTo(newName);
    }

    @Test
    @DisplayName("Set and get 'academicYear' property - Successful")
    public void setAndGetAcademicYear_Successful() {
        // Arrange & Act: Set a new academic year
        Integer newAcademicYear = 2024;
        subject.setAcademicYear(newAcademicYear);

        // Assert: Verify that the academic year was updated correctly
        assertThat(subject.getAcademicYear()).isEqualTo(newAcademicYear);
    }

    @Test
    @DisplayName("Verify 'isDeleted' field is initialized to false")
    public void verifyIsDeleted_InitializedToFalse() {
        // Assert: Verify that isDeleted is initialized to false by default
        assertThat(subject.isDeleted()).isFalse();
    }

    @Test
    @DisplayName("Deactivate Subject and verify 'isDeleted' status")
    public void deactivateSubject_VerifyIsDeletedStatus() {
        // Act: Deactivate the subject
        subject.deactivate();

        // Assert: Verify that isDeleted is true after deactivation
        assertThat(subject.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Equality test for Subject instances")
    public void equalityTest() {
        // Arrange: Create a second Subject instance with the same attributes
        User teacher = TestEntityFactory.createDefaultUser();
        Career career = TestEntityFactory.createDefaultCareer();
        Subject equalSubject = TestEntityFactory.createSubject(
                subject.getId(),
                subject.getName(),
                subject.getAcademicYear(),
                career,
                teacher
        );

        // Act & Assert: Verify that both instances are equal
        assertThat(subject).isEqualTo(equalSubject);
    }

    @Test
    @DisplayName("Equality test for Subject instances with different isDeleted values")
    public void equalityTest_SameAttributesDifferentIsDeleted() {
        // Arrange: Create a second Subject instance with the same attributes but deactivate it
        User teacher = TestEntityFactory.createDefaultUser();
        Career career = TestEntityFactory.createDefaultCareer();
        Subject equalSubject = TestEntityFactory.createSubject(
                subject.getId(),
                subject.getName(),
                subject.getAcademicYear(),
                career,
                teacher
        );
        equalSubject.deactivate(); // Set isDeleted to true

        // Act & Assert: Verify that both instances are not considered equal
        assertThat(subject).isNotEqualTo(equalSubject);

        // Additional Assertion: Verify that isDeleted is different
        assertThat(subject.isDeleted()).isFalse();
        assertThat(equalSubject.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Verify relationships with Career and User")
    public void verifyRelationships() {
        // Arrange: Get the related entities
        Career career = TestEntityFactory.createDefaultCareer();
        User teacher = TestEntityFactory.createDefaultUser();

        // Act: Set the relationships
        subject.setCareer(career);
        subject.setTeacher(teacher);

        // Assert: Verify that the relationships were set correctly
        assertThat(subject.getCareer()).isEqualTo(career);
        assertThat(subject.getTeacher()).isEqualTo(teacher);
    }
}