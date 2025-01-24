package com.casdeveloper.dataserver.api;

import com.casdeveloper.dataserver.model.Course;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@Tag(name = "COURSE_API", description = "API of Course")
public interface CourseApi {

    @Operation(summary = "Get Course by Id")
    @GetMapping("/{id}")
    ResponseEntity<Course> findById(@Parameter(description = "id of course to be searched") @PathVariable(name = "id") Long id);

    @Operation(summary = "Get All Courses")
    @GetMapping("/")
    ResponseEntity<List<Course>> findAll();

    @Operation(summary = "Save Course")
    @PostMapping("/{course}")
    ResponseEntity<Course> save(@Parameter(description = "course to be saved") @RequestBody Course course);
}
