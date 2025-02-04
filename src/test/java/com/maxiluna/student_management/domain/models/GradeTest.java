package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class GradeTest {

    private Grade grade;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a default Grade instance before each test
        Subject subject = TestEntityFactory.createDefaultSubject();
        Student student = TestEntityFactory.createDefaultStudent();
        ClassRecord classRecord = TestEntityFactory.createDefaultClassRecord();
        grade = TestEntityFactory.createGrade(
                1L,
                LocalDate.of(2023, 10, 1),
                "Final Exam",
                95.0,
                subject,
                student,
                classRecord
        );
    }

    @Test
    @DisplayName("Create Grade instance")
    public void createGrade_SuccessfulInstantiation() {
        // Act & Assert: Verify that the Grade instance is not null
        assertThat(grade).isNotNull();
    }

    @Test
    @DisplayName("Set and get 'recordDate' property - Successful")
    public void setAndGetRecordDate_Successful() {
        // Arrange & Act: Set a new record date
        LocalDate newRecordDate = LocalDate.of(2023, 10, 2);
        grade.setRecordDate(newRecordDate);

        // Assert: Verify that the record date was updated correctly
        assertThat(grade.getRecordDate()).isEqualTo(newRecordDate);
    }

    @Test
    @DisplayName("Set and get 'description' property - Successful")
    public void setAndGetDescription_Successful() {
        // Arrange & Act: Set a new description
        String newDescription = "Midterm Exam";
        grade.setDescription(newDescription);

        // Assert: Verify that the description was updated correctly
        assertThat(grade.getDescription()).isEqualTo(newDescription);
    }

    @Test
    @DisplayName("Set and get 'score' property - Successful")
    public void setAndGetScore_Successful() {
        // Arrange & Act: Set a new score
        Double newScore = 85.5;
        grade.setScore(newScore);

        // Assert: Verify that the score was updated correctly
        assertThat(grade.getScore()).isEqualTo(newScore);
    }

    @Test
    @DisplayName("Set and get 'subject' property - Successful")
    public void setAndGetSubject_Successful() {
        // Arrange & Act: Set a new subject
        Subject newSubject = TestEntityFactory.createDefaultSubject();
        grade.setSubject(newSubject);

        // Assert: Verify that the subject was updated correctly
        assertThat(grade.getSubject()).isEqualTo(newSubject);
    }

    @Test
    @DisplayName("Set and get 'student' property - Successful")
    public void setAndGetStudent_Successful() {
        // Arrange & Act: Set a new student
        Student newStudent = TestEntityFactory.createDefaultStudent();
        grade.setStudent(newStudent);

        // Assert: Verify that the student was updated correctly
        assertThat(grade.getStudent()).isEqualTo(newStudent);
    }

    @Test
    @DisplayName("Set and get 'classRecord' property - Successful")
    public void setAndGetClassRecord_Successful() {
        // Arrange & Act: Set a new class record
        ClassRecord newClassRecord = TestEntityFactory.createDefaultClassRecord();
        grade.setClassRecord(newClassRecord);

        // Assert: Verify that the class record was updated correctly
        assertThat(grade.getClassRecord()).isEqualTo(newClassRecord);
    }

    @Test
    @DisplayName("Verify 'isDeleted' field is initialized to false")
    public void verifyIsDeleted_InitializedToFalse() {
        // Assert: Verify that isDeleted is initialized to false by default
        assertThat(grade.isDeleted()).isFalse();
    }

    @Test
    @DisplayName("Deactivate Grade and verify 'isDeleted' status")
    public void deactivateGrade_VerifyIsDeletedStatus() {
        // Act: Deactivate the grade
        grade.deactivate();

        // Assert: Verify that isDeleted is true after deactivation
        assertThat(grade.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Equality test for Grade instances")
    public void equalityTest() {
        // Arrange: Create a second Grade instance with the same attributes
        Subject subject = TestEntityFactory.createDefaultSubject();
        Student student = TestEntityFactory.createDefaultStudent();
        ClassRecord classRecord = TestEntityFactory.createDefaultClassRecord();
        Grade equalGrade = TestEntityFactory.createGrade(
                grade.getId(),
                grade.getRecordDate(),
                grade.getDescription(),
                grade.getScore(),
                subject,
                student,
                classRecord
        );

        // Act & Assert: Verify that both instances are equal
        assertThat(grade).isEqualTo(equalGrade);
    }

    @Test
    @DisplayName("Equality test for Grade instances with different isDeleted values")
    public void equalityTest_SameAttributesDifferentIsDeleted() {
        // Arrange: Create a second Grade instance with the same attributes but deactivate it
        Subject subject = TestEntityFactory.createDefaultSubject();
        Student student = TestEntityFactory.createDefaultStudent();
        ClassRecord classRecord = TestEntityFactory.createDefaultClassRecord();
        Grade equalGrade = TestEntityFactory.createGrade(
                grade.getId(),
                grade.getRecordDate(),
                grade.getDescription(),
                grade.getScore(),
                subject,
                student,
                classRecord
        );
        equalGrade.deactivate(); // Set isDeleted to true

        // Act & Assert: Verify that both instances are not considered equal
        assertThat(grade).isNotEqualTo(equalGrade);

        // Additional Assertion: Verify that isDeleted is different
        assertThat(grade.isDeleted()).isFalse();
        assertThat(equalGrade.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Verify relationships with Subject, Student, and ClassRecord")
    public void verifyRelationships() {
        // Arrange: Get the related entities
        Subject subject = TestEntityFactory.createDefaultSubject();
        Student student = TestEntityFactory.createDefaultStudent();
        ClassRecord classRecord = TestEntityFactory.createDefaultClassRecord();

        // Act: Set the relationships
        grade.setSubject(subject);
        grade.setStudent(student);
        grade.setClassRecord(classRecord);

        // Assert: Verify that the relationships were set correctly
        assertThat(grade.getSubject()).isEqualTo(subject);
        assertThat(grade.getStudent()).isEqualTo(student);
        assertThat(grade.getClassRecord()).isEqualTo(classRecord);
    }
}