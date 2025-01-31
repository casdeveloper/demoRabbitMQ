package com.casdeveloper.dataserver.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.StandardCharsets;

@Configuration
@ComponentScan(basePackages = {"com.casdeveloper.core.model", "com.casdeveloper.core.helper", "com.casdeveloper.core.repository", "com.casdeveloper.core.entity"})
@EnableJpaRepositories(basePackages = {"com.casdeveloper.core.repository"})
@EntityScan(basePackages = {"com.casdeveloper.core.entity"})
public class CoreConfig {

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }
}
