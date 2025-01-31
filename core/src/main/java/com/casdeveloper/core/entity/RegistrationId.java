package com.casdeveloper.core.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class RegistrationId implements Serializable {

    public RegistrationId(Course course, Person person) {
        this.course = course;
        this.person = person;
    }

    public RegistrationId() {};


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "courseid", nullable = false, updatable = false, insertable = false)
    private Course course;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "personid", nullable = false, updatable = false, insertable = false)
    private Person person;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
