package com.casdeveloper.dataserver.api.controller;

import com.casdeveloper.dataserver.api.CourseApi;
import com.casdeveloper.dataserver.model.Course;
import com.casdeveloper.dataserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseController implements CourseApi {

    private final CourseService courseService;

    public CourseController(@Autowired CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public ResponseEntity<Course> findById(Long id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Course> save(Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
    }
}
