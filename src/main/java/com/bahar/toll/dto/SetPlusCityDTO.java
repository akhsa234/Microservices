package com.bahar.toll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SetPlusCityDTO {

    private Integer id;
    private String name;
    private Float latitude;
    private Float longitude;

}
