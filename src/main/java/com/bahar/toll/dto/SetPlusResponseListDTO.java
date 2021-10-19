package com.bahar.toll.dto;

import lombok.Data;

import java.util.List;

@Data
public class SetPlusResponseListDTO <T> {

    private long id;
    private String actionCode;
    private String actionMessage;
    private List<String> errorMessages;
    private String referenceNumber;
    private String traceNumber;
    private List<T> data;
}
