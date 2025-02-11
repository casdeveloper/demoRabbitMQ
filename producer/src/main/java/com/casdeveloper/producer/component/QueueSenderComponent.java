package com.casdeveloper.producer.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QueueSenderComponent {

    RabbitTemplate rabbitTemplate;

    Queue queuePerson;
    Queue queueCourse;
    Queue queueRegistration;

    public QueueSenderComponent(@Autowired RabbitTemplate rabbitTemplate, @Qualifier("courseQueue") @Autowired Queue queueCourse, @Qualifier("registrationQueue") Queue queueRegistration, @Qualifier("personQueue") Queue queuePerson) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueCourse = queueCourse;
        this.queueRegistration = queueRegistration;
        this.queuePerson = queuePerson;
    }

    public void sendPerson(String message) {
        rabbitTemplate.convertAndSend(queuePerson.getName(), message);
    }

    public void sendCourse(String message) {
        rabbitTemplate.convertAndSend(queueCourse.getName(), message);
    }

    public void sendRegistration(String message) {
        rabbitTemplate.convertAndSend(queueRegistration.getName(), message);
    }
}
