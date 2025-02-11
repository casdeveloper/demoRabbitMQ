package com.casdeveloper.producer.api.controller;

import com.casdeveloper.core.model.PersonDto;
import com.casdeveloper.producer.api.CallCenterApi;
import com.casdeveloper.producer.service.CallCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CallCenterController implements CallCenterApi {

    CallCenterService callCenterService;

    public CallCenterController(@Autowired CallCenterService callCenterService) {
        this.callCenterService = callCenterService;
    }

    @Override
    public ResponseEntity<UUID> sendPerson(PersonDto personDto) {

        try {

            return new ResponseEntity<>(callCenterService.sendNewPerson(personDto), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
