package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.persistence.entities.CareerJpa;
import com.maxiluna.student_management.persistence.entities.SubjectJpa;
import com.maxiluna.student_management.persistence.entities.UserJpa;
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
class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TestEntityFactory testEntityFactory;

    private SubjectJpa subject;
    private CareerJpa career;
    private UserJpa teacher;

    @BeforeEach
    void setUp() {
        // Arrange: Create and save a career and a teacher before each test
        career = testEntityFactory.createAndSaveCareer(
                "Computer Science",
                "University of Example",
                4.0
        );

        teacher = testEntityFactory.createAndSaveUser(
                "teacher@example.com",
                "password123",
                "Jane",
                "Doe",
                LocalDate.of(1980, 5, 10),
                UserRole.TEACHER
        );

        // Arrange: Create a subject
        subject = SubjectJpa.builder()
                .name("Mathematics")
                .academicYear(2023)
                .career(career)
                .teacher(teacher)
                .isDeleted(false)
                .build();
    }

    @Test
    @DisplayName("Save and retrieve a subject")
    void saveAndRetrieveSubject_Successful() {
        // Act: Save the subject to the database
        subjectRepository.save(subject);

        // Assert: Verify that the subject can be retrieved by ID
        Optional<SubjectJpa> foundSubject = subjectRepository.findById(subject.getId());
        assertThat(foundSubject).isPresent();
        assertThat(foundSubject.get().getName()).isEqualTo(subject.getName());
    }

    @Test
    @DisplayName("Find subjects by career ID")
    void findByCareerId_Successful() {
        // Act: Save the subject to the database
        subjectRepository.save(subject);

        // Assert: Verify that the subject can be retrieved by career ID
        List<SubjectJpa> subjects = subjectRepository.findByCareerId(career.getId());
        assertThat(subjects).isNotEmpty();
        assertThat(subjects.get(0).getName()).isEqualTo(subject.getName());
    }

    @Test
    @DisplayName("Find subjects by teacher ID")
    void findByTeacherId_Successful() {
        // Act: Save the subject to the database
        subjectRepository.save(subject);

        // Assert: Verify that the subject can be retrieved by teacher ID
        List<SubjectJpa> subjects = subjectRepository.findByTeacherId(teacher.getId());
        assertThat(subjects).isNotEmpty();
        assertThat(subjects.get(0).getName()).isEqualTo(subject.getName());
    }

    @Test
    @DisplayName("Delete a subject")
    void deleteSubject_Successful() {
        // Act: Save and then delete the subject
        subjectRepository.save(subject);
        subjectRepository.delete(subject);

        // Assert: Verify that the subject is no longer in the database
        Optional<SubjectJpa> deletedSubject = subjectRepository.findById(subject.getId());
        assertThat(deletedSubject).isEmpty();
    }
}