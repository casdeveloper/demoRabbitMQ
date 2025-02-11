package com.casdeveloper.producer.service.impl;

import com.casdeveloper.core.helper.Utilities;
import com.casdeveloper.core.model.PersonDto;
import com.casdeveloper.core.model.RMQMessage;
import com.casdeveloper.core.model.type.TypeActionMessage;
import com.casdeveloper.core.model.type.TypeMessage;
import com.casdeveloper.producer.component.QueueSenderComponent;
import com.casdeveloper.producer.service.CallCenterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CallCenterServiceImpl implements CallCenterService {

    QueueSenderComponent queueSenderComponent;

    ObjectMapper objectMapper;

    public CallCenterServiceImpl(@Autowired QueueSenderComponent queueSenderComponent) {
        this.queueSenderComponent = queueSenderComponent;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public UUID sendNewPerson(PersonDto personDto) {
        try {

            RMQMessage message = RMQMessage.builder().uuid(Utilities.getUuid()).typeMessage(TypeMessage.PERSON).typeActionMessage(TypeActionMessage.SAVE).list(false).message(objectMapper.writeValueAsString(personDto)).date(Utilities.getDate()).build();
            queueSenderComponent.sendPerson(objectMapper.writeValueAsString(message));
            return message.getUuid();
        } catch (Exception e) {
            return null;
        }
    }
}
