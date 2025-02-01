package com.maxiluna.student_management.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

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
