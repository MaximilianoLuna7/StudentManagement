package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.domain.enums.UserRole;
import com.maxiluna.student_management.persistence.entities.ClassRecordJpa;
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
class ClassRecordRepositoryTest {

    @Autowired
    private ClassRecordRepository classRecordRepository;

    @Autowired
    private TestEntityFactory testEntityFactory;

    private ClassRecordJpa classRecord;
    private SubjectJpa subject;

    @BeforeEach
    void setUp() {
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
        subject = testEntityFactory.createAndSaveSubject("Mathematics", 2023, career, teacher);

        // Arrange: Create and save a class record
        classRecord = testEntityFactory.createAndSaveClassRecord(
                "Introduction to Algebra",
                "Solve equations and graph functions",
                LocalDate.of(2023, 10, 15),
                subject
        );
    }

    @Test
    @DisplayName("Save and retrieve a class record")
    void saveAndRetrieveClassRecord_Successful() {
        // Act: Retrieve the class record by ID
        Optional<ClassRecordJpa> foundClassRecord = classRecordRepository.findById(classRecord.getId());

        // Assert: Verify that the class record can be retrieved by ID
        assertThat(foundClassRecord).isPresent();
        assertThat(foundClassRecord.get().getTopic()).isEqualTo(classRecord.getTopic());
    }

    @Test
    @DisplayName("Find class records by subject ID")
    void findBySubjectId_Successful() {
        // Act: Retrieve class records by subject ID
        List<ClassRecordJpa> classRecords = classRecordRepository.findBySubjectId(subject.getId());

        // Assert: Verify that the class record is included in the results
        assertThat(classRecords).isNotEmpty();
        assertThat(classRecords.stream().anyMatch(cr -> cr.getId().equals(classRecord.getId()))).isTrue();
    }

    @Test
    @DisplayName("Delete a class record")
    void deleteClassRecord_Successful() {
        // Act: Delete the class record
        classRecordRepository.delete(classRecord);

        // Assert: Verify that the class record is no longer in the database
        Optional<ClassRecordJpa> deletedClassRecord = classRecordRepository.findById(classRecord.getId());
        assertThat(deletedClassRecord).isEmpty();
    }
}