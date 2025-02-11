package com.casdeveloper.dataserver.api;

import com.casdeveloper.core.model.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@Tag(name = "PERSON_API", description = "API of Person")
public interface PersonApi {

    @Operation(summary = "Get Person by Id")
    @GetMapping("/{id}")
    ResponseEntity<PersonDto> findById(@Parameter(description = "id of person to be searched") @PathVariable("id") Long id);

    @Operation(summary = "Get All Persons")
    @GetMapping("/all")
    ResponseEntity<List<PersonDto>> findAll();

    @Operation(summary = "Save Person")
    @PostMapping(value = "/save")
    ResponseEntity<PersonDto> save(@Parameter(description = "person to be saved") @RequestBody PersonDto person) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
