package com.casdeveloper.producer.service;

import com.casdeveloper.core.model.PersonDto;

import java.util.UUID;

public interface CallCenterService {

    UUID sendNewPerson(PersonDto personDto);
}
