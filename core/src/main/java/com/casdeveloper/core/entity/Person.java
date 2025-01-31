package com.casdeveloper.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Person implements Serializable {

    public Person(Long id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {};

    @Id
    private Long id;

    private String name;

    private Long age;


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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
