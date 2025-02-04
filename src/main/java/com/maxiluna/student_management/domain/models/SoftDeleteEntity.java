package com.maxiluna.student_management.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Abstract base class to implement the soft delete pattern.
 * All entities in the system inherit from this class to include the `isDeleted` field.
 */
@Getter
@Setter
@ToString
@SuperBuilder
@EqualsAndHashCode
public abstract class SoftDeleteEntity {
    private boolean isDeleted;

    public SoftDeleteEntity() {
        this.isDeleted = false;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void deactivate() {
        this.isDeleted = true;
    }
}