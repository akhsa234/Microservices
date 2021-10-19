package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "ANNUAL_TOLL_DETAILS")
public class AnnualTollDetail {
    @Transient //TODO
    public static final String SEQUENCE_NAME = "AnnualTollDetail_sequence";
    @Id
    private long id;
    private Integer tollId;
    private String description;
    private BigDecimal amount;
}
