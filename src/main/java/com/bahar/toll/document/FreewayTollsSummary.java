package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "FREEWAY_TOLLS_SUMMARY")
public class FreewayTollsSummary {

    @Transient //TODO
    public static final String SEQUENCE_NAME = "FreewayTollsSummary_sequence";
    @Id
    private long id;
    private Integer PlateNo;
    private BigDecimal totalAmount;
    private List<DateDetail> details;
    private UUID enquiryId;
}
