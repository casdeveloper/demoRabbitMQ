package com.casdeveloper.consumer.service;

import com.casdeveloper.core.model.PersonDto;

import java.lang.reflect.InvocationTargetException;

public interface BackOfficeService {

    PersonDto registerPerson(PersonDto personDto) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
