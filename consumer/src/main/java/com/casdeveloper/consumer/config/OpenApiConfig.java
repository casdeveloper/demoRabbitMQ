package com.casdeveloper.consumer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("RabbitMQ - Consumer Module")
                        .description("Sample messaging consumer application using RabbitMQ with SpringBoot")
                        .version("v1.0")
                        .contact(new Contact().name("casdeveloper").email("casdeveloper@icloud.com").url("https://github.com/casdeveloper/rabbitmq"))
                );
    }

}
