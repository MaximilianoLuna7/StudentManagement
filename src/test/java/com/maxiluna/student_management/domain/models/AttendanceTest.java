package com.maxiluna.student_management.domain.models;

import com.maxiluna.student_management.domain.enums.AttendanceStatus;
import com.maxiluna.student_management.domain.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class AttendanceTest {

    private Attendance attendance;

    @BeforeEach
    public void setUp() {
        // Arrange: Create a default Attendance instance before each test
        Student student = TestEntityFactory.createDefaultStudent();
        ClassRecord classRecord = TestEntityFactory.createDefaultClassRecord();
        attendance = TestEntityFactory.createAttendance(
                1L,
                LocalDate.of(2023, 10, 1),
                student,
                classRecord,
                AttendanceStatus.PRESENT
        );
    }

    @Test
    @DisplayName("Create Attendance instance")
    public void createAttendance_SuccessfulInstantiation() {
        // Act & Assert: Verify that the Attendance instance is not null
        assertThat(attendance).isNotNull();
    }

    @Test
    @DisplayName("Set and get 'dateRecord' property - Successful")
    public void setAndGetDateRecord_Successful() {
        // Arrange & Act: Set a new date record
        LocalDate newDateRecord = LocalDate.of(2023, 10, 2);
        attendance.setDateRecord(newDateRecord);

        // Assert: Verify that the date record was updated correctly
        assertThat(attendance.getDateRecord()).isEqualTo(newDateRecord);
    }

    @Test
    @DisplayName("Set and get 'student' property - Successful")
    public void setAndGetStudent_Successful() {
        // Arrange & Act: Set a new student
        Student newStudent = TestEntityFactory.createDefaultStudent();
        attendance.setStudent(newStudent);

        // Assert: Verify that the student was updated correctly
        assertThat(attendance.getStudent()).isEqualTo(newStudent);
    }

    @Test
    @DisplayName("Set and get 'classRecord' property - Successful")
    public void setAndGetClassRecord_Successful() {
        // Arrange & Act: Set a new class record
        ClassRecord newClassRecord = TestEntityFactory.createDefaultClassRecord();
        attendance.setClassRecord(newClassRecord);

        // Assert: Verify that the class record was updated correctly
        assertThat(attendance.getClassRecord()).isEqualTo(newClassRecord);
    }

    @Test
    @DisplayName("Set and get 'attendanceStatus' property - Successful")
    public void setAndGetAttendanceStatus_Successful() {
        // Arrange & Act: Set a new attendance status
        AttendanceStatus newStatus = AttendanceStatus.ABSENT;
        attendance.setAttendanceStatus(newStatus);

        // Assert: Verify that the attendance status was updated correctly
        assertThat(attendance.getAttendanceStatus()).isEqualTo(newStatus);
    }

    @Test
    @DisplayName("Verify 'isDeleted' field is initialized to false")
    public void verifyIsDeleted_InitializedToFalse() {
        // Assert: Verify that isDeleted is initialized to false by default
        assertThat(attendance.isDeleted()).isFalse();
    }

    @Test
    @DisplayName("Deactivate Attendance and verify 'isDeleted' status")
    public void deactivateAttendance_VerifyIsDeletedStatus() {
        // Act: Deactivate the attendance
        attendance.deactivate();

        // Assert: Verify that isDeleted is true after deactivation
        assertThat(attendance.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Equality test for Attendance instances")
    public void equalityTest() {
        // Arrange: Create a second Attendance instance with the same attributes
        Student student = TestEntityFactory.createDefaultStudent();
        ClassRecord classRecord = TestEntityFactory.createDefaultClassRecord();
        Attendance equalAttendance = TestEntityFactory.createAttendance(
                attendance.getId(),
                attendance.getDateRecord(),
                student,
                classRecord,
                attendance.getAttendanceStatus()
        );

        // Act & Assert: Verify that both instances are equal
        assertThat(attendance).isEqualTo(equalAttendance);
    }

    @Test
    @DisplayName("Equality test for Attendance instances with different isDeleted values")
    public void equalityTest_SameAttributesDifferentIsDeleted() {
        // Arrange: Create a second Attendance instance with the same attributes but deactivate it
        Student student = TestEntityFactory.createDefaultStudent();
        ClassRecord classRecord = TestEntityFactory.createDefaultClassRecord();
        Attendance equalAttendance = TestEntityFactory.createAttendance(
                attendance.getId(),
                attendance.getDateRecord(),
                student,
                classRecord,
                attendance.getAttendanceStatus()
        );
        equalAttendance.deactivate(); // Set isDeleted to true

        // Act & Assert: Verify that both instances are not considered equal
        assertThat(attendance).isNotEqualTo(equalAttendance);

        // Additional Assertion: Verify that isDeleted is different
        assertThat(attendance.isDeleted()).isFalse();
        assertThat(equalAttendance.isDeleted()).isTrue();
    }

    @Test
    @DisplayName("Verify relationships with Student and ClassRecord")
    public void verifyRelationships() {
        // Arrange: Get the related entities
        Student student = TestEntityFactory.createDefaultStudent();
        ClassRecord classRecord = TestEntityFactory.createDefaultClassRecord();

        // Act: Set the relationships
        attendance.setStudent(student);
        attendance.setClassRecord(classRecord);

        // Assert: Verify that the relationships were set correctly
        assertThat(attendance.getStudent()).isEqualTo(student);
        assertThat(attendance.getClassRecord()).isEqualTo(classRecord);
    }
}