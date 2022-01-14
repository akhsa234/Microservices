package com.bahar.externalService.setplus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetPlusResponseListDTO <T> {

    private long id;
    private String actionCode;
    private String actionMessage;
    private List<String> errorMessages;
    private String referenceNumber;
    private String traceNumber;
    private List<T> data;
}
