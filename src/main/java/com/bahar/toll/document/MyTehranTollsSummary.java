package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "MY_TEHRAN_TOLLS_SUMMARY")
public class MyTehranTollsSummary {

    @Transient
    public static final String SEQUENCE_NAME = "MyTehranTollsSummary_sequence";
    @Id
    private long id;
    private Integer PlateNo;
    private BigDecimal totalAmount;
    private Integer type;
    private List<MyTehranDateDetail> details;
    private UUID EnquiryId;


    public void addMyTehranDateDetail(MyTehranDateDetail detail){
        if(details==null){
            details= new ArrayList<MyTehranDateDetail>();

        }
        details.add(detail);
    }
}
