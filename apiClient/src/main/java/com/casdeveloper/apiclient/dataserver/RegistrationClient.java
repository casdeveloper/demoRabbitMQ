package com.casdeveloper.apiclient.dataserver;

import com.casdeveloper.core.model.RegistrationDto;
import com.casdeveloper.core.model.RegistrationIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
@FeignClient(value = "registration-client", url = "${feignclient.urlDataServer}", path = "/api/registration")
public interface RegistrationClient {

    @GetMapping("/")
    ResponseEntity<RegistrationDto> getRegistrationById(@RequestBody RegistrationIdDto id) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;

    @GetMapping("/all")
    ResponseEntity<List<RegistrationDto>> getAllRegistrations();

    @PostMapping("/save")
    ResponseEntity<RegistrationDto> saveRegistration(@RequestBody RegistrationDto registration) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
