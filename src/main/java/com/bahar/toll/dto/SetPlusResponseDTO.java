package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetPlusResponseDTO<T> {

    private String actionCode;
    private String actionMessage;
    private List<String> errorMessages;
    private String referenceNumber;
    private String traceNumber;
    private T data;
}
