package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AnnualTollDetailDTO {

    private Integer tollId;
    private String description;
    private BigDecimal amount;
}
