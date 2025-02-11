package com.casdeveloper.core.model;

import com.casdeveloper.core.model.type.TypeActionMessage;
import com.casdeveloper.core.model.type.TypeMessage;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RMQMessage implements Serializable {

    private UUID uuid;
    private TypeMessage typeMessage;
    private TypeActionMessage typeActionMessage;
    private Boolean list;
    private String message;
    private Date date;

}
