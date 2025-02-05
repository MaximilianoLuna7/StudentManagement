package com.maxiluna.student_management.persistence.repositories;

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
@Import(TestEntityFactory.class) // Importa TestEntityFactory como un bean
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityFactory testEntityFactory;

    private StudentJpa student;

    @BeforeEach
    void setUp() {
        // Arrange: Create and save a default student before each test
        student = testEntityFactory.createAndSaveStudent(
                "John",
                "Doe",
                "john.doe@example.com",
                LocalDate.of(2000, 1, 1),
                "12345678",
                "New York",
                2020
        );
    }

    @Test
    @DisplayName("Save and retrieve a student")
    void saveAndRetrieveStudent_Successful() {
        // Act: Retrieve the student by ID
        Optional<StudentJpa> foundStudent = studentRepository.findById(student.getId());

        // Assert: Verify that the student can be retrieved by ID
        assertThat(foundStudent).isPresent();
        assertThat(foundStudent.get().getEmail()).isEqualTo(student.getEmail());
    }

    @Test
    @DisplayName("Find student by email")
    void findByEmail_Successful() {
        // Act: Retrieve the student by email
        Optional<StudentJpa> foundStudent = studentRepository.findByEmail(student.getEmail());

        // Assert: Verify that the student can be retrieved by email
        assertThat(foundStudent).isPresent();
        assertThat(foundStudent.get().getFirstName()).isEqualTo(student.getFirstName());
    }

    @Test
    @DisplayName("Check if email exists")
    void existsByEmail_Successful() {
        // Act: Check if the email exists
        boolean exists = studentRepository.existsByEmail(student.getEmail());

        // Assert: Verify that the email exists in the database
        assertThat(exists).isTrue();
    }

    @Test
    @DisplayName("Find students by admission year")
    void findByAdmissionYear_Successful() {
        // Act: Retrieve students by admission year
        List<StudentJpa> students = studentRepository.findByAdmissionYear(student.getAdmissionYear());

        // Assert: Verify that the student is included in the results
        assertThat(students).isNotEmpty();
        assertThat(students.stream().anyMatch(s -> s.getId().equals(student.getId()))).isTrue();
    }

    @Test
    @DisplayName("Delete a student")
    void deleteStudent_Successful() {
        // Act: Delete the student
        studentRepository.delete(student);

        // Assert: Verify that the student is no longer in the database
        Optional<StudentJpa> deletedStudent = studentRepository.findById(student.getId());
        assertThat(deletedStudent).isEmpty();
    }
}