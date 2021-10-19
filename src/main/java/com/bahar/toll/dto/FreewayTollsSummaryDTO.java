package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FreewayTollsSummaryDTO {

    private Integer PlateNo;
    private BigDecimal totalAmount;
    private List<DateDetailDTO> details;
    private UUID enquiryId;

}
