package com.casdeveloper.dataserver.service;

import com.casdeveloper.core.model.RegistrationDto;
import com.casdeveloper.core.model.RegistrationIdDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface RegistrationService {

    RegistrationDto getById(RegistrationIdDto registrationId) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    List<RegistrationDto> getAll();

    RegistrationDto save(RegistrationDto registrationDto) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
