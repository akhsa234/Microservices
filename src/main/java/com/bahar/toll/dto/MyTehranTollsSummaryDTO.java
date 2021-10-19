package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MyTehranTollsSummaryDTO {

    private long id;
    private Integer PlateNo;
    private BigDecimal totalAmount;
    private Integer type;
    private List<MyTehranDateDetailDTO> details;
    private UUID EnquiryId;



    public void addMyTehranDateDetailDTO(MyTehranDateDetailDTO detail){
        if(details==null){
            details= new ArrayList<MyTehranDateDetailDTO>();

        }
        details.add(detail);
    }

}
