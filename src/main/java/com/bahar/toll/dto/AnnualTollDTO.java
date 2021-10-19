package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AnnualTollDTO {

    private String deviceId;
    private NumberPlatesModelDTO numberPlatesObj;
    private String vin;
    private String nationalCode;
    private BigDecimal totalAmount;



}
