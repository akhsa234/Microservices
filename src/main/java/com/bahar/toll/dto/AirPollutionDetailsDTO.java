package com.bahar.toll.dto;

import com.bahar.document.AirPollutionSeasonData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AirPollutionDetailsDTO {

    private long id;
    private String plateNo;
    private AirPollutionSeasonData seasons;
}
