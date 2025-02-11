package com.casdeveloper.producer.api;

import com.casdeveloper.core.model.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/callcenter")
public interface CallCenterApi {

    @PostMapping("/sendPerson")
    public ResponseEntity<UUID> sendPerson(@RequestBody PersonDto personDto);
}
