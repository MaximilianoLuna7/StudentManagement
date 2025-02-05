package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.domain.enums.StudentStatus;
import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.persistence.entities.EnrollmentJpa;
import com.maxiluna.student_management.persistence.entities.StudentJpa;
import com.maxiluna.student_management.persistence.entities.SubjectJpa;
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
class EnrollmentRepositoryTest {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private TestEntityFactory testEntityFactory;

    private EnrollmentJpa enrollment;
    private StudentJpa student;
    private SubjectJpa subject;

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

        // Arrange: Create and save a subject
        var career = testEntityFactory.createAndSaveCareer("Computer Science", "University of Example", 4.0);
        var teacher = testEntityFactory.createAndSaveUser(
                "teacher@example.com",
                "password123",
                "Jane",
                "Doe",
                LocalDate.of(1980, 5, 10),
                UserRole.TEACHER
        );
        subject = testEntityFactory.createAndSaveSubject(
                "Mathematics",
                2023,
                career,
                teacher
        );

        // Arrange: Create and save an enrollment
        enrollment = testEntityFactory.createAndSaveEnrollment(student, subject, StudentStatus.REGULAR);
    }

    @Test
    @DisplayName("Save and retrieve an enrollment")
    void saveAndRetrieveEnrollment_Successful() {
        // Act: Retrieve the enrollment by ID
        Optional<EnrollmentJpa> foundEnrollment = enrollmentRepository.findById(enrollment.getId());

        // Assert: Verify that the enrollment can be retrieved by ID
        assertThat(foundEnrollment).isPresent();
        assertThat(foundEnrollment.get().getStudent().getId()).isEqualTo(student.getId());
    }

    @Test
    @DisplayName("Find enrollment by student and subject")
    void findByStudentIdAndSubjectId_Successful() {
        // Act: Retrieve the enrollment by student and subject IDs
        Optional<EnrollmentJpa> foundEnrollment = enrollmentRepository.findByStudentIdAndSubjectId(student.getId(), subject.getId());

        // Assert: Verify that the enrollment can be retrieved by student and subject IDs
        assertThat(foundEnrollment).isPresent();
        assertThat(foundEnrollment.get().getStudentStatus()).isEqualTo(StudentStatus.REGULAR);
    }

    @Test
    @DisplayName("Find enrollments by student ID")
    void findByStudentId_Successful() {
        // Act: Retrieve enrollments by student ID
        List<EnrollmentJpa> enrollments = enrollmentRepository.findByStudentId(student.getId());

        // Assert: Verify that the enrollment is included in the results
        assertThat(enrollments).isNotEmpty();
        assertThat(enrollments.stream().anyMatch(e -> e.getId().equals(enrollment.getId()))).isTrue();
    }

    @Test
    @DisplayName("Delete an enrollment")
    void deleteEnrollment_Successful() {
        // Act: Delete the enrollment
        enrollmentRepository.delete(enrollment);

        // Assert: Verify that the enrollment is no longer in the database
        Optional<EnrollmentJpa> deletedEnrollment = enrollmentRepository.findById(enrollment.getId());
        assertThat(deletedEnrollment).isEmpty();
    }
}