package com.casdeveloper.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Course implements Serializable {

    public Course(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Course() {};

    @Id
    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
