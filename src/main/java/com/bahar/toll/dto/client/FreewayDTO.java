package com.bahar.toll.dto.client;

import com.bahar.dto.NumberPlatesModelDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FreewayDTO {


    private int numberPlate;
    private NumberPlatesModelDTO numberPlatesObj;//???

    private String chassisNumber;
    private String deviceId;



}
 /*
    {
    "numberPlatesObj":{"ir":"38","p2":"88","p3":"964","pc":"ن"},
    "deviceId":"70938737",
    "chassisNumber":"NAACY1YEXJF430377",
    "barcode":"96550017"
    }
     */
