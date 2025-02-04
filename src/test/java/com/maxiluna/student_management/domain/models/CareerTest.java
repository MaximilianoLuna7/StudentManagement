package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CareerTest {

    private Career career;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a default Career instance before each test
        career = TestEntityFactory.createDefaultCareer();
    }

    @Test
    @DisplayName("Create Career instance")
    public void createCareer_SuccessfulInstantiation() {
        // Act & Assert: Verify that the Career instance is not null
        assertThat(career).isNotNull();
    }

    @Test
    @DisplayName("Set and get 'name' property - Successful")
    public void setAndGetName_Successful() {
        // Arrange & Act: Set a new name
        String newName = "Software Engineering";
        career.setName(newName);

        // Assert: Verify that the name was updated correctly
        assertThat(career.getName()).isEqualTo(newName);
    }

    @Test
    @DisplayName("Set and get 'institutionName' property - Successful")
    public void setAndGetInstitutionName_Successful() {
        // Arrange & Act: Set a new institution name
        String newInstitutionName = "Tech University";
        career.setInstitutionName(newInstitutionName);

        // Assert: Verify that the institution name was updated correctly
        assertThat(career.getInstitutionName()).isEqualTo(newInstitutionName);
    }

    @Test
    @DisplayName("Set and get 'durationInYears' property - Successful")
    public void setAndGetDurationInYears_Successful() {
        // Arrange & Act: Set a new duration in years
        Double newDurationInYears = 5.0;
        career.setDurationInYears(newDurationInYears);

        // Assert: Verify that the duration in years was updated correctly
        assertThat(career.getDurationInYears()).isEqualTo(newDurationInYears);
    }

    @Test
    @DisplayName("Verify 'isDeleted' field is initialized to false")
    public void verifyIsDeleted_InitializedToFalse() {
        // Assert: Verify that isDeleted is initialized to false by default
        assertThat(career.isDeleted()).isFalse();
    }

    @Test
    @DisplayName("Deactivate Career and verify 'isDeleted' status")
    public void deactivateCareer_VerifyIsDeletedStatus() {
        // Act: Deactivate the career
        career.deactivate();

        // Assert: Verify that isDeleted is true after deactivation
        assertThat(career.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Equality test for Career instances")
    public void equalityTest() {
        // Arrange: Create a second Career instance with the same attributes
        Career equalCareer = TestEntityFactory.createCareer(
                career.getId(),
                career.getName(),
                career.getInstitutionName(),
                career.getDurationInYears()
        );

        // Act & Assert: Verify that both instances are equal
        assertThat(career).isEqualTo(equalCareer);
    }

    @Test
    @DisplayName("Equality test for Career instances with different isDeleted values")
    public void equalityTest_SameAttributesDifferentIsDeleted() {
        // Arrange: Create a second Career instance with the same attributes but deactivate it
        Career equalCareer = TestEntityFactory.createCareer(
                career.getId(),
                career.getName(),
                career.getInstitutionName(),
                career.getDurationInYears()
        );
        equalCareer.deactivate(); // Set isDeleted to true

        // Act & Assert: Verify that both instances are not considered equal
        assertThat(career).isNotEqualTo(equalCareer);

        // Additional Assertion: Verify that isDeleted is different
        assertThat(career.isDeleted()).isFalse();
        assertThat(equalCareer.isDeleted()).isTrue();
    }
}