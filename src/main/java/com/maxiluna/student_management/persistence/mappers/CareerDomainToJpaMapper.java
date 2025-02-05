package com.maxiluna.student_management.persistence.mappers;

import com.maxiluna.student_management.domain.models.Career;
import com.maxiluna.student_management.persistence.entities.CareerJpa;

public class CareerDomainToJpaMapper {

    /**
     * Converts a CareerJpa entity to a Career domain entity.
     */
    public static Career toDomain(CareerJpa careerJpa) {
        if (careerJpa == null) {
            return null;
        }
        return Career.builder()
                .id(careerJpa.getId())
                .name(careerJpa.getName())
                .institutionName(careerJpa.getInstitutionName())
                .durationInYears(careerJpa.getDurationInYears())
                .build();
    }

    /**
     * Converts a Career domain entity to a CareerJpa entity.
     */
    public static CareerJpa toJpa(Career career) {
        if (career == null) {
            return null;
        }
        return CareerJpa.builder()
                .id(career.getId())
                .name(career.getName())
                .institutionName(career.getInstitutionName())
                .durationInYears(career.getDurationInYears())
                .isDeleted(false) // New entities are not deleted by default
                .build();
    }
}