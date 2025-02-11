package com.casdeveloper.core.model.type;

import java.io.Serializable;

public enum TypeActionMessage implements Serializable {

    SAVE("Save"),
    REMOVE("Remove"),
    GET("Get"),
    GETALL("GetAll");

    public final String value;

    TypeActionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static TypeActionMessage fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        for (TypeActionMessage e : TypeActionMessage.values()) {
            if (value.equals(e.value)) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }

}
