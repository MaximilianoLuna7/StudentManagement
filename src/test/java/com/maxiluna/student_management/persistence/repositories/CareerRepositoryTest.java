package com.maxiluna.student_management.persistence.repositories;

import com.maxiluna.student_management.persistence.entities.CareerJpa;
import com.maxiluna.student_management.persistence.utils.TestEntityFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestEntityFactory.class)
class CareerRepositoryTest {

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private TestEntityFactory testEntityFactory;

    private CareerJpa career;

    @BeforeEach
    void setUp() {
        // Arrange: Create and save a default career before each test
        career = testEntityFactory.createAndSaveCareer(
                "Computer Science",
                "University of Example",
                4.0
        );
    }

    @Test
    @DisplayName("Save and retrieve a career")
    void saveAndRetrieveCareer_Successful() {
        // Act: Retrieve the career by ID
        Optional<CareerJpa> foundCareer = careerRepository.findById(career.getId());

        // Assert: Verify that the career can be retrieved by ID
        assertThat(foundCareer).isPresent();
        assertThat(foundCareer.get().getName()).isEqualTo(career.getName());
    }

    @Test
    @DisplayName("Find career by name")
    void findByName_Successful() {
        // Act: Retrieve the career by name
        Optional<CareerJpa> foundCareer = careerRepository.findByName(career.getName());

        // Assert: Verify that the career can be retrieved by name
        assertThat(foundCareer).isPresent();
        assertThat(foundCareer.get().getInstitutionName()).isEqualTo(career.getInstitutionName());
    }

    @Test
    @DisplayName("Check if career name exists")
    void existsByName_Successful() {
        // Act: Check if the career name exists
        boolean exists = careerRepository.existsByName(career.getName());

        // Assert: Verify that the career name exists in the database
        assertThat(exists).isTrue();
    }

    @Test
    @DisplayName("Delete a career")
    void deleteCareer_Successful() {
        // Act: Delete the career
        careerRepository.delete(career);

        // Assert: Verify that the career is no longer in the database
        Optional<CareerJpa> deletedCareer = careerRepository.findById(career.getId());
        assertThat(deletedCareer).isEmpty();
    }
}