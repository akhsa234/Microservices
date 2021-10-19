package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MyTehranDateDetailDTO {

    private long id;
    private String date;
    private BigDecimal amount;
    private Integer paymentStatus;

}
