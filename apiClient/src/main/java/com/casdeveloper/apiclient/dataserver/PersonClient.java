package com.casdeveloper.apiclient.dataserver;

import com.casdeveloper.core.model.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
@FeignClient(value = "person-client", url = "${feignclient.urlDataServer}", path = "/api/person")
public interface PersonClient {

    @GetMapping("/{id}")
    ResponseEntity<PersonDto> findById(@PathVariable("id") Long id);

    @GetMapping("/all")
    ResponseEntity<List<PersonDto>> findAll();

    @PostMapping(value = "/save")
    ResponseEntity<PersonDto> save(@RequestBody PersonDto person) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
