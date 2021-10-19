package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "SET_PLUS_PAYMENT_INPUT")
public class SetPlusPaymentInput {

    @Transient
    public static final String SEQUENCE_NAME = "SetPlusPaymentInput_sequence";


    @Id
    private long id;
    private String type;
    private String refId;
    private String hashId;
    private String phone;
    private String chassisNumber;
    private int numberPlate;
    private long traceNumber;
    private String deviceId;
    private String enquiryId;
    private String amount;
    private String billId;
    private List<String> dates = new ArrayList<>();
    private List<String> billIds;
    private String tempData;
    private String token;
    private String requestSource;
    private String registerDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    @Transient
    private String barcode;

    @Transient
    private long personCarId;

    @Transient
    private NumberPlatesModel numberPlatesObj;


}
