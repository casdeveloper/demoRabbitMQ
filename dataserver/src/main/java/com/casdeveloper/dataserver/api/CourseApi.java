package com.casdeveloper.dataserver.api;

import com.casdeveloper.core.model.CourseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public interface CourseApi {

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(@PathVariable("id") Long id);

    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> findAll();

    @PostMapping(value = "/save")
    public ResponseEntity<CourseDto> save(@RequestBody CourseDto course) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
