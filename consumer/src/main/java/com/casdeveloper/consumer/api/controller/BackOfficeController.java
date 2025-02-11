package com.casdeveloper.consumer.api.controller;

import com.casdeveloper.consumer.api.BackOfficeApi;
import com.casdeveloper.consumer.service.BackOfficeService;
import com.casdeveloper.core.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.InvocationTargetException;

@Component
public class BackOfficeController implements BackOfficeApi {

    private BackOfficeService backOfficeService;

    public BackOfficeController(@Autowired BackOfficeService backOfficeService) {
        this.backOfficeService = backOfficeService;
    }

    @Override
    public ResponseEntity<PersonDto> registerPerson(Long id, String name, Long age) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        PersonDto personDto = new PersonDto(id, name, age);
        return new ResponseEntity<>(backOfficeService.registerPerson(personDto), HttpStatus.CREATED);
    }
}
