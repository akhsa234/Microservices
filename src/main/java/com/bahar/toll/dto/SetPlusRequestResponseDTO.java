package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetPlusRequestResponseDTO {

    private long id;
    private String deviceId;
    private String type;
    private String reqDate;
    private int numberPlate;
    private String response;
}
