package com.casdeveloper.dataserver.api.controller;

import com.casdeveloper.core.model.CourseDto;
import com.casdeveloper.dataserver.api.CourseApi;
import com.casdeveloper.dataserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class CourseController implements CourseApi {

    CourseService courseService;

    public CourseController(@Autowired CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public ResponseEntity<CourseDto> findById(Long id) {
        return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseDto>> findAll() {
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseDto> save(CourseDto course) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.OK);
    }
}
