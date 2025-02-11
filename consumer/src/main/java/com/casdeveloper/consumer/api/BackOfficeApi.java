package com.casdeveloper.consumer.api;


import com.casdeveloper.core.model.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/backoffice")
public interface BackOfficeApi {

    @PostMapping("/{id}/{name}/{age}")
    ResponseEntity<PersonDto> registerPerson(@PathVariable Long id, @PathVariable String name, @PathVariable Long age) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;


}
