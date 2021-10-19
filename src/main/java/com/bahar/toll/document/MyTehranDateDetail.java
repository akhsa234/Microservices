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
@Document(collection = "MY_TEHRAN_DATA_DETAIL")
public class MyTehranDateDetail {

    @Transient
    public static final String SEQUENCE_NAME = "MyTehranDateDetail_sequence";
    @Id
    private long id;
    private String date;
    private BigDecimal amount;
    private Integer paymentStatus;


}
