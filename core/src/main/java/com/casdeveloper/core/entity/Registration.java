package com.casdeveloper.core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Registration implements Serializable {

    public Registration(RegistrationId id) {
        this.id = id;
    }

    public Registration() {}

    @EmbeddedId
    private RegistrationId id;

    public RegistrationId getId() {
        return id;
    }

    public void setId(RegistrationId id) {
        this.id = id;
    }
}
