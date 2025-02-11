package com.casdeveloper.dataserver.api;

import com.casdeveloper.core.model.CourseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/course")
@Tag(name = "COURSE_API", description = "API of Course")
public interface CourseApi {

    @Operation(summary = "Get Course by Id")
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(@Parameter(description = "id of course to be searched") @PathVariable("id") Long id);

    @Operation(summary = "Get All Courses")
    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> findAll();

    @Operation(summary = "Save Course")
    @PostMapping(value = "/save")
    public ResponseEntity<CourseDto> save(@Parameter(description = "course to be saved") @RequestBody CourseDto course) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
