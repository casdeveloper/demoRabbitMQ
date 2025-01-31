package com.casdeveloper.dataserver.api.controller;

import com.casdeveloper.core.model.PersonDto;
import com.casdeveloper.dataserver.api.PersonApi;
import com.casdeveloper.dataserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class PersonController implements PersonApi {

    private PersonService personService;

    public PersonController(@Autowired PersonService personService) {
        this.personService = personService;
    }


    @Override
    public ResponseEntity<PersonDto> findById(Long id) {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDto>> findAll() {
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDto> save(PersonDto person) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.OK);
    }
}
