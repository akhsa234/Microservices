package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "SET_PLUS_RESPONSE")
public class SetPlusResponse <T> {

    @Transient
    public static final String SEQUENCE_NAME = "SetPlusResponse_sequence";

    @Id
    private long id;
    private String actionCode;
    private String actionMessage;
    private List<String> errorMessages;
    private String referenceNumber;
    private String traceNumber;
    private T data;
}
