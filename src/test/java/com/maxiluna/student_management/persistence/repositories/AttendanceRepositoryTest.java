package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.domain.enums.AttendanceStatus;
import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.persistence.entities.AttendanceJpa;
import com.maxiluna.student_management.persistence.entities.ClassRecordJpa;
import com.maxiluna.student_management.persistence.entities.StudentJpa;
import com.maxiluna.student_management.persistence.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestEntityFactory.class)
class AttendanceRepositoryTest {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private TestEntityFactory testEntityFactory;

    private AttendanceJpa attendance;
    private StudentJpa student;
    private ClassRecordJpa classRecord;

    @BeforeEach
    void setUp() {
        // Arrange: Create and save a student
        student = testEntityFactory.createAndSaveStudent(
                "John",
                "Doe",
                "john.doe@example.com",
                LocalDate.of(2000, 1, 1),
                "12345678",
                "New York",
                2020
        );

        // Arrange: Create and save a subject and class record
        var career = testEntityFactory.createAndSaveCareer("Computer Science", "University of Example", 4.0);
        var teacher = testEntityFactory.createAndSaveUser(
                "teacher@example.com",
                "password123",
                "Jane",
                "Doe",
                LocalDate.of(1980, 5, 10),
                UserRole.TEACHER
        );
        var subject = testEntityFactory.createAndSaveSubject("Mathematics", 2023, career, teacher);
        classRecord = testEntityFactory.createAndSaveClassRecord(
                "Introduction to Algebra",
                "Solve equations and graph functions",
                LocalDate.of(2023, 10, 15),
                subject
        );

        // Arrange: Create and save an attendance record
        attendance = testEntityFactory.createAndSaveAttendance(
                LocalDate.of(2023, 10, 15),
                student,
                classRecord,
                AttendanceStatus.PRESENT
        );
    }

    @Test
    @DisplayName("Save and retrieve an attendance record")
    void saveAndRetrieveAttendance_Successful() {
        // Act: Retrieve the attendance record by ID
        Optional<AttendanceJpa> foundAttendance = attendanceRepository.findById(attendance.getId());

        // Assert: Verify that the attendance record can be retrieved by ID
        assertThat(foundAttendance).isPresent();
        assertThat(foundAttendance.get().getAttendanceStatus()).isEqualTo(AttendanceStatus.PRESENT);
    }

    @Test
    @DisplayName("Find attendances by class record ID")
    void findByClassRecordId_Successful() {
        // Act: Retrieve attendances by class record ID
        List<AttendanceJpa> attendances = attendanceRepository.findByClassRecordId(classRecord.getId());

        // Assert: Verify that the attendance record is included in the results
        assertThat(attendances).isNotEmpty();
        assertThat(attendances.stream().anyMatch(a -> a.getId().equals(attendance.getId()))).isTrue();
    }

    @Test
    @DisplayName("Find attendances by student ID")
    void findByStudentId_Successful() {
        // Act: Retrieve attendances by student ID
        List<AttendanceJpa> attendances = attendanceRepository.findByStudentId(student.getId());

        // Assert: Verify that the attendance record is included in the results
        assertThat(attendances).isNotEmpty();
        assertThat(attendances.stream().anyMatch(a -> a.getId().equals(attendance.getId()))).isTrue();
    }

    @Test
    @DisplayName("Delete an attendance record")
    void deleteAttendance_Successful() {
        // Act: Delete the attendance record
        attendanceRepository.delete(attendance);

        // Assert: Verify that the attendance record is no longer in the database
        Optional<AttendanceJpa> deletedAttendance = attendanceRepository.findById(attendance.getId());
        assertThat(deletedAttendance).isEmpty();
    }
}