package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "AIR_POLLUTION_SEASON_DATA")
public class AirPollutionSeasonData {

    @Transient
    public static final String SEQUENCE_NAME = "AirPollutionSeasonData_sequence";
    @Id
    private long id;
    private int entryDaysCount;
    private String lastBillingDate;
    private int season;
    private int year;

}
