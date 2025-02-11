package com.casdeveloper.producer.api;

import com.casdeveloper.core.model.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/callcenter")
@Tag(name = "CALLCENTER_API", description = "Api of CallCenter")
public interface CallCenterApi {

    @Operation(summary = "Send Person to Registration")
    @PostMapping("/sendPerson")
    public ResponseEntity<UUID> sendPerson(@RequestBody PersonDto personDto);
}
