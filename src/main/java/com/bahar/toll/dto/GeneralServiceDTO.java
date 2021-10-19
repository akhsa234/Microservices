package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GeneralServiceDTO {

    private String deviceId;
    private NumberPlatesModelDTO numberPlatesObj;
}
