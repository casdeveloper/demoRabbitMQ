package com.casdeveloper.core.model;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class RegistrationDto implements Serializable {


    public RegistrationDto(RegistrationIdDto registrationIdDto) {
        this.registrationIdDto = registrationIdDto;
    }

    private RegistrationDto (){};;

    private RegistrationIdDto registrationIdDto;

    public RegistrationIdDto getRegistrationIdDto() {
        return registrationIdDto;
    }

    public void setRegistrationIdDto(RegistrationIdDto registrationIdDto) {
        this.registrationIdDto = registrationIdDto;
    }
}
