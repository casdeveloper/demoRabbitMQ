package com.casdeveloper.dataserver.api;

import com.casdeveloper.core.model.RegistrationDto;
import com.casdeveloper.core.model.RegistrationIdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/registration")
@Tag(name = "REGISTRATION_API", description = "API of Registration")
public interface RegistrationApi {

    @Operation(summary = "Get Registration by Id")
    @GetMapping("/")
    ResponseEntity<RegistrationDto> getRegistrationById(@Parameter(description = "id of registration to be searched") @RequestBody RegistrationIdDto id) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    @Operation(summary = "Get All Registrations")
    @GetMapping("/all")
    ResponseEntity<List<RegistrationDto>> getAllRegistrations();

    @Operation(summary = "Save Registration")
    @PostMapping("/save")
    ResponseEntity<RegistrationDto> saveRegistration(@Parameter(description = "registration to be saved") @RequestBody RegistrationDto registration) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
