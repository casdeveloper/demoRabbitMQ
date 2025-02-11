package com.casdeveloper.core.helper;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public interface Utilities {

    static UUID getUuid(){
        return UUID.randomUUID();
    };

    static Date getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return new Date();
    }
}
