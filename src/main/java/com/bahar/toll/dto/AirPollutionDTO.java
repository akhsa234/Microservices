package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AirPollutionDTO {

    private long id;
    private String deviceId;
    private NumberPlatesModelDTO numberPlatesObj;
    private BigDecimal amount;
}

//{"amount":0,"deviceId":"1683fbd55e9630a0","numberPlatesObj":{"ir":"38","p2":"88","p3":"964","pc":"ن"}}