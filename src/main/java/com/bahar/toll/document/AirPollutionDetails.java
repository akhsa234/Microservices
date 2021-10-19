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
@Document(collection = "AIR_POLLUTION_DETAILS")
public class AirPollutionDetails {

    @Transient //TODO
    public static final String SEQUENCE_NAME = "AirPollutionDetails_sequence";
    @Id
    private long id;
    private String plateNo;
    private AirPollutionSeasonData seasons;
}
