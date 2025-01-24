package com.casdeveloper.dataserver.api.controller;

import com.casdeveloper.dataserver.api.PersonApi;
import com.casdeveloper.dataserver.model.Person;
import com.casdeveloper.dataserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonController implements PersonApi {

    private final PersonService personService;

    public PersonController(@Autowired PersonService personService) {
        this.personService = personService;
    }

    @Override
    public ResponseEntity<Person> findById(Long id) {
        Person person = personService.findById(id);
        if (person == null) {
            return new ResponseEntity<>(new Person(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<Person>> findByAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> save(Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.OK);
    }
}
