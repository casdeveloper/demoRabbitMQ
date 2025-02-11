package com.casdeveloper.apiclient.dataserver;

import com.casdeveloper.core.model.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
@FeignClient(value = "course-client", url = "${feignclient.urlDataServer}")
@RequestMapping("/api/course")
public interface CourseClient {

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(@PathVariable("id") Long id);

    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> findAll();

    @PostMapping(value = "/save")
    public ResponseEntity<CourseDto> save(@RequestBody CourseDto course) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
