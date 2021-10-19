package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PayMyTehranTollsDTO {

    private long id;
    private Integer PlateNo;
    private Boolean success;
    private Boolean myTehranSuccess;
    private BigDecimal totalPaidAmount;
    private String RRN;
    private Integer paidTollNumber;
}
