package com.casdeveloper.apiclient.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.casdeveloper.apiclient.dataserver"})
@EntityScan(basePackages = {"com.casdeveloper.core.model", "com.casdeveloper.core.entity"})
public class ApiClientConfig {
}
