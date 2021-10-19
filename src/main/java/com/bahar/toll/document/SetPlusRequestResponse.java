package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "SET_PLUS_REQUEST_RESPONSE")
public class SetPlusRequestResponse {

    @Transient
    public static final String SEQUENCE_NAME = "SetPlusRequestResponse_sequence";

    @Id
    private long id;
    private String deviceId;
    private String type;
    private String reqDate = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").
                                 format(Calendar.getInstance().getTime());
    private int numberPlate;
    private String response;
}
