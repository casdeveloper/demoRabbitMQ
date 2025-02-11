package com.casdeveloper.consumer.component;

import com.casdeveloper.consumer.service.BackOfficeService;
import com.casdeveloper.core.helper.GenericClass;
import com.casdeveloper.core.model.PersonDto;
import com.casdeveloper.core.model.RMQMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
public class QueueReceiveComponent extends GenericClass {


    BackOfficeService backOfficeService;

    public QueueReceiveComponent(@Autowired BackOfficeService backOfficeService) {
        this.backOfficeService = backOfficeService;
    }

    @RabbitListener(queues = {"${queue.person.name}"})
    public void receivePerson(@Payload String message) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, JsonProcessingException {
        System.out.println(message);
        RMQMessage rmqMessage = new RMQMessage();
        rmqMessage = objectMapper.readValue(message, RMQMessage.class);
        if (rmqMessage != null) {

            switch (rmqMessage.getTypeActionMessage()) {
                case SAVE:
                        backOfficeService.registerPerson(objectMapper.readValue(rmqMessage.getMessage(), PersonDto.class));
                    break;
                case REMOVE:
                    break;
                default:
                    break;
            }
        }
        System.out.println("Queue received: " + message);
    }

    @RabbitListener(queues = {"${queue.course.name}"})
    public void receiveCourse(@Payload String message) {
        System.out.println("Queue received: " + message);
    }

    @RabbitListener(queues = {"${queue.registration.name}"})
    public void receiveRegistration(@Payload String message) {
        System.out.println("Queue received: " + message);
    }
}
