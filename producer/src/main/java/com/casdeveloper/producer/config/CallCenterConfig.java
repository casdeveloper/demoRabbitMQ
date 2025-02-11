package com.casdeveloper.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.casdeveloper.apiclient.dataserver"})
@EntityScan(basePackages = {"com.casdeveloper.core.model", "com.casdeveloper.core.entity"})
public class CallCenterConfig {

    @Value("${queue.person.name}")
    private String messagePerson;

    @Value("${queue.course.name}")
    private String messageCouse;

    @Value("${queue.person.name}")
    private String messageRegistration;

    @Bean(name = "personQueue")
    public Queue personQueue() {
        return new Queue(messagePerson, true);
    };

    @Bean(name = "courseQueue")
    public Queue courseQueue() {
        return new Queue(messageCouse, true);
    }

    @Bean(name="registrationQueue")
    public Queue registrationQueue() {
        return new Queue(messageRegistration, true);
    }

}
