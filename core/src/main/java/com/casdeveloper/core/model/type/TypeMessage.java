package com.casdeveloper.core.model.type;

import java.io.Serializable;

public enum TypeMessage implements Serializable {

    PERSON("Person"),
    COURSE("Course"),
    REGISTRATION("Registration");

    private final String value;

    TypeMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static TypeMessage getEnum(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        for (TypeMessage e : TypeMessage.values()) {
            if (value.equalsIgnoreCase(e.getValue())) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }
}
