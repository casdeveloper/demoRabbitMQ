package com.casdeveloper.dataserver.service;

import com.casdeveloper.core.model.PersonDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface PersonService {

    PersonDto getPerson(Long id);

    List<PersonDto> getPersons();

    PersonDto savePerson(PersonDto personDto) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
