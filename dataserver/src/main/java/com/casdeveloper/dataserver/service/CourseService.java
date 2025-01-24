package com.casdeveloper.dataserver.service;

import com.casdeveloper.dataserver.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course);
}
