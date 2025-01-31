package com.casdeveloper.core.model;

public class RegistrationIdDto {

    public RegistrationIdDto(CourseDto courseDto, PersonDto personDto) {
        this.courseDto = courseDto;
        this.personDto = personDto;
    }

    public RegistrationIdDto() {}

    private CourseDto courseDto;
    private PersonDto personDto;

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public void setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }
}
