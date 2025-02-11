package com.casdeveloper.core.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationId implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "courseid", nullable = false, updatable = false, insertable = false)
    private Course course;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "personid", nullable = false, updatable = false, insertable = false)
    private Person person;

}
