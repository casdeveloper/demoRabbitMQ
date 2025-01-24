package com.casdeveloper.dataserver.service;

import com.casdeveloper.dataserver.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();
    Person findById(Long id);
    Person save(Person person);
}
