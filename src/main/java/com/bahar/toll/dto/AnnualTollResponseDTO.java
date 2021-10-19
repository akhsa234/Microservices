package com.bahar.toll.dto;

import com.bahar.document.AnnualTollDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AnnualTollResponseDTO {

    private Integer plateNo;
    private BigDecimal totalAmount;
    private String enquiryId;
    private List<AnnualTollDetail> items;

}
