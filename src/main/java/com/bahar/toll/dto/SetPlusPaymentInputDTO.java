package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetPlusPaymentInputDTO {

    private long id;
    private int numberPlate;
    private NumberPlatesModelDTO numberPlatesObj;
    private List<String> dates = new ArrayList<>();

    private String chassisNumber;
    private String deviceId;
    private String enquiryId;
    private String amount;
    private long traceNumber;

}
