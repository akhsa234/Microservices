package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "ANNUAL_TOLL_RESPONSE")
public class AnnualTollResponse {

    @Transient //TODO
    public static final String SEQUENCE_NAME = "AnnualTollResponse_sequence";
    @Id
    private long id;
    private Integer plateNo;
    private BigDecimal totalAmount;
    private String enquiryId;
    private List<AnnualTollDetail> items;
}
