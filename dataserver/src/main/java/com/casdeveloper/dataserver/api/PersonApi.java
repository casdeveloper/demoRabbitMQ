package com.casdeveloper.dataserver.api;

import com.casdeveloper.core.model.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public interface PersonApi {

    @GetMapping("/{id}")
    ResponseEntity<PersonDto> findById(@PathVariable("id") Long id);

    @GetMapping("/all")
    ResponseEntity<List<PersonDto>> findAll();

    @PostMapping(value = "/save")
    ResponseEntity<PersonDto> save(@RequestBody PersonDto person) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
