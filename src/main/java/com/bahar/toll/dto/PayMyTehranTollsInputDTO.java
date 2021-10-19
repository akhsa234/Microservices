package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PayMyTehranTollsInputDTO {

    private long id;
    private String EnquiryId;
    private Integer PlateNo;
    private BigDecimal MyTehranAmount;
    private List<String> MyTehranDates;
}
