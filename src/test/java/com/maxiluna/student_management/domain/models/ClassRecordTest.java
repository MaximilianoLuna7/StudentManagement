package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ClassRecordTest {

    private ClassRecord classRecord;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a default ClassRecord instance before each test
        Subject subject = TestEntityFactory.createDefaultSubject();
        classRecord = TestEntityFactory.createClassRecord(
                1L,
                "Mathematics Basics",
                "Introduction to Algebra",
                LocalDate.of(2023, 10, 1),
                subject
        );
    }

    @Test
    @DisplayName("Create ClassRecord instance")
    public void createClassRecord_SuccessfulInstantiation() {
        // Act & Assert: Verify that the ClassRecord instance is not null
        assertThat(classRecord).isNotNull();
    }

    @Test
    @DisplayName("Set and get 'topic' property - Successful")
    public void setAndGetTopic_Successful() {
        // Arrange & Act: Set a new topic
        String newTopic = "Advanced Mathematics";
        classRecord.setTopic(newTopic);

        // Assert: Verify that the topic was updated correctly
        assertThat(classRecord.getTopic()).isEqualTo(newTopic);
    }

    @Test
    @DisplayName("Set and get 'activities' property - Successful")
    public void setAndGetActivities_Successful() {
        // Arrange & Act: Set new activities
        String newActivities = "Solving equations";
        classRecord.setActivities(newActivities);

        // Assert: Verify that the activities were updated correctly
        assertThat(classRecord.getActivities()).isEqualTo(newActivities);
    }

    @Test
    @DisplayName("Set and get 'date' property - Successful")
    public void setAndGetDate_Successful() {
        // Arrange & Act: Set a new date
        LocalDate newDate = LocalDate.of(2023, 10, 2);
        classRecord.setDate(newDate);

        // Assert: Verify that the date was updated correctly
        assertThat(classRecord.getDate()).isEqualTo(newDate);
    }

    @Test
    @DisplayName("Set and get 'subject' property - Successful")
    public void setAndGetSubject_Successful() {
        // Arrange & Act: Set a new subject
        Subject newSubject = TestEntityFactory.createDefaultSubject();
        classRecord.setSubject(newSubject);

        // Assert: Verify that the subject was updated correctly
        assertThat(classRecord.getSubject()).isEqualTo(newSubject);
    }

    @Test
    @DisplayName("Verify 'isDeleted' field is initialized to false")
    public void verifyIsDeleted_InitializedToFalse() {
        // Assert: Verify that isDeleted is initialized to false by default
        assertThat(classRecord.isDeleted()).isFalse();
    }

    @Test
    @DisplayName("Deactivate ClassRecord and verify 'isDeleted' status")
    public void deactivateClassRecord_VerifyIsDeletedStatus() {
        // Act: Deactivate the class record
        classRecord.deactivate();

        // Assert: Verify that isDeleted is true after deactivation
        assertThat(classRecord.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Equality test for ClassRecord instances")
    public void equalityTest() {
        // Arrange: Create a second ClassRecord instance with the same attributes
        Subject subject = TestEntityFactory.createDefaultSubject();
        ClassRecord equalClassRecord = TestEntityFactory.createClassRecord(
                classRecord.getId(),
                classRecord.getTopic(),
                classRecord.getActivities(),
                classRecord.getDate(),
                subject
        );

        // Act & Assert: Verify that both instances are equal
        assertThat(classRecord).isEqualTo(equalClassRecord);
    }

    @Test
    @DisplayName("Equality test for ClassRecord instances with different isDeleted values")
    public void equalityTest_SameAttributesDifferentIsDeleted() {
        // Arrange: Create a second ClassRecord instance with the same attributes but deactivate it
        Subject subject = TestEntityFactory.createDefaultSubject();
        ClassRecord equalClassRecord = TestEntityFactory.createClassRecord(
                classRecord.getId(),
                classRecord.getTopic(),
                classRecord.getActivities(),
                classRecord.getDate(),
                subject
        );
        equalClassRecord.deactivate(); // Set isDeleted to true

        // Act & Assert: Verify that both instances are not considered equal
        assertThat(classRecord).isNotEqualTo(equalClassRecord);

        // Additional Assertion: Verify that isDeleted is different
        assertThat(classRecord.isDeleted()).isFalse();
        assertThat(equalClassRecord.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Verify relationship with Subject")
    public void verifyRelationshipWithSubject() {
        // Arrange: Get a new subject
        Subject newSubject = TestEntityFactory.createDefaultSubject();

        // Act: Set the subject
        classRecord.setSubject(newSubject);

        // Assert: Verify that the subject was set correctly
        assertThat(classRecord.getSubject()).isEqualTo(newSubject);
    }
}