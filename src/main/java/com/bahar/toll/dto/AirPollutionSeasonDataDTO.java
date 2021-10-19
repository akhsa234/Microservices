package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AirPollutionSeasonDataDTO {

    private long id;
    private int entryDaysCount;
    private String lastBillingDate;
    private int season;
    private int year;

}
