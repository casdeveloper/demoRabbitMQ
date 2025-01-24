package com.casdeveloper.dataserver.api;


import com.casdeveloper.dataserver.model.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Tag(name = "PERSON_API", description = "API of Person")
public interface PersonApi {

    @Operation(summary = "Get Person by Id")
    @GetMapping("/{id}")
    ResponseEntity<Person> findById(@Parameter(description = "id of person to be searched") @PathVariable(name = "id") Long id);

    @Operation(summary = "Get All Persons")
    @GetMapping("/")
    ResponseEntity<List<Person>> findByAll();

    @Operation(summary = "Save Person")
    @PostMapping("/{person}")
    ResponseEntity<Person> save(@Parameter(description = "person to be saved") @RequestBody Person person);
}
