package com.bahar.toll.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NumberPlatesModelDTO {

    private String id;
    private String p2;
    private String p3;
    private String pc;
    private String ir;

    @Override
    public String toString(){
        return p2 + pc  + p3 + "IR" + ir;
    }

}