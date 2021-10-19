package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PayMyTehranTollsHeaderDTO {

    private String authorization;
    private String traceNumber;
    private String deviceId;
    private int plateNo;
}
