package com.casdeveloper.consumer.service.impl;

import com.casdeveloper.apiclient.dataserver.PersonClient;
import com.casdeveloper.consumer.service.BackOfficeService;
import com.casdeveloper.core.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class BackOfficeServiceImpl implements BackOfficeService {

    private PersonClient personClient;


    public BackOfficeServiceImpl(@Autowired PersonClient personClient) {
        this.personClient = personClient;
    }

    @Override
    public PersonDto registerPerson(PersonDto personDto) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        ResponseEntity<PersonDto> response = personClient.save(personDto);
        return response.getBody();
    }
}
