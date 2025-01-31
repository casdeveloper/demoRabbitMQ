package com.casdeveloper.dataserver.service;

import com.casdeveloper.core.model.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto getById(Long id);

    List<CourseDto> getAll();

    CourseDto saveCourse(CourseDto courseDto);
}
