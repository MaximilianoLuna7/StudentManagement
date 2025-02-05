package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.persistence.entities.ClassRecordJpa;
import com.maxiluna.student_management.persistence.entities.GradeJpa;
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
class GradeRepositoryTest {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private TestEntityFactory testEntityFactory;

    private GradeJpa grade;
    private StudentJpa student;
    private SubjectJpa subject;
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
        subject = testEntityFactory.createAndSaveSubject("Mathematics", 2023, career, teacher);
        classRecord = testEntityFactory.createAndSaveClassRecord(
                "Introduction to Algebra",
                "Solve equations and graph functions",
                LocalDate.of(2023, 10, 15),
                subject
        );

        // Arrange: Create and save a grade
        grade = testEntityFactory.createAndSaveGrade(
                LocalDate.of(2023, 10, 15),
                "Final Exam",
                95.0,
                subject,
                student,
                classRecord
        );
    }

    @Test
    @DisplayName("Save and retrieve a grade")
    void saveAndRetrieveGrade_Successful() {
        // Act: Retrieve the grade by ID
        Optional<GradeJpa> foundGrade = gradeRepository.findById(grade.getId());

        // Assert: Verify that the grade can be retrieved by ID
        assertThat(foundGrade).isPresent();
        assertThat(foundGrade.get().getScore()).isEqualTo(grade.getScore());
    }

    @Test
    @DisplayName("Find grades by class record ID")
    void findByClassRecordId_Successful() {
        // Act: Retrieve grades by class record ID
        List<GradeJpa> grades = gradeRepository.findByClassRecordId(classRecord.getId());

        // Assert: Verify that the grade is included in the results
        assertThat(grades).isNotEmpty();
        assertThat(grades.stream().anyMatch(g -> g.getId().equals(grade.getId()))).isTrue();
    }

    @Test
    @DisplayName("Find grades by student ID")
    void findByStudentId_Successful() {
        // Act: Retrieve grades by student ID
        List<GradeJpa> grades = gradeRepository.findByStudentId(student.getId());

        // Assert: Verify that the grade is included in the results
        assertThat(grades).isNotEmpty();
        assertThat(grades.stream().anyMatch(g -> g.getId().equals(grade.getId()))).isTrue();
    }

    @Test
    @DisplayName("Delete a grade")
    void deleteGrade_Successful() {
        // Act: Delete the grade
        gradeRepository.delete(grade);

        // Assert: Verify that the grade is no longer in the database
        Optional<GradeJpa> deletedGrade = gradeRepository.findById(grade.getId());
        assertThat(deletedGrade).isEmpty();
    }
}