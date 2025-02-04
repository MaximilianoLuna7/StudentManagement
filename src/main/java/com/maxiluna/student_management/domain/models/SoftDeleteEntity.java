package com.maxiluna.student_management.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Clase abstracta base para implementar el patrón de eliminación lógica (soft delete).
 * Todas las entidades del sistema heredan de esta clase para incluir el campo `isDeleted`.
 */
@Getter
@Setter
@ToString
@SuperBuilder
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
