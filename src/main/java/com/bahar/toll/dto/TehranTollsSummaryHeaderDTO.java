package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TehranTollsSummaryHeaderDTO {

    private String authorization;
    private String traceNumber;
    private String deviceId;
    private int plateNo;
}
