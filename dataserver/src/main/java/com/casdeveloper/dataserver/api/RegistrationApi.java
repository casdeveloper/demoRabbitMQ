package com.casdeveloper.dataserver.api;

import com.casdeveloper.core.entity.RegistrationId;
import com.casdeveloper.core.model.RegistrationDto;
import com.casdeveloper.core.model.RegistrationIdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/registration")
public interface RegistrationApi {

    @GetMapping("/")
    ResponseEntity<RegistrationDto> getRegistrationById(@RequestBody RegistrationIdDto id) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    @GetMapping("/all")
    ResponseEntity<List<RegistrationDto>> getAllRegistrations();

    @PostMapping("/save")
    ResponseEntity<RegistrationDto> saveRegistration(@RequestBody RegistrationDto registration) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
