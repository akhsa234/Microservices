package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "DATE_DETAILS")
public class DateDetail {

    @Transient //TODO
    public static final String SEQUENCE_NAME = "DateDetail_sequence";
    @Id
    private long id;
    private Date date;
    private BigDecimal amount;
    private String billId;
    private String gateway;

}
