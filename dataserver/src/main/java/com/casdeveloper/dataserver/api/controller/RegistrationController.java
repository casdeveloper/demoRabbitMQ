package com.casdeveloper.dataserver.api.controller;

import com.casdeveloper.core.entity.RegistrationId;
import com.casdeveloper.core.model.RegistrationDto;
import com.casdeveloper.core.model.RegistrationIdDto;
import com.casdeveloper.dataserver.api.RegistrationApi;
import com.casdeveloper.dataserver.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class RegistrationController implements RegistrationApi {

    private RegistrationService registrationService;

    public RegistrationController(@Autowired RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public ResponseEntity<RegistrationDto> getRegistrationById(RegistrationIdDto id) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return new ResponseEntity<>(registrationService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations() {
        return new ResponseEntity<>(registrationService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RegistrationDto> saveRegistration(RegistrationDto registration) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return new ResponseEntity<>(registrationService.save(registration),HttpStatus.OK);
    }
}
