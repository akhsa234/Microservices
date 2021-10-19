package com.bahar.toll.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberPlatesModel{
    private String p2;
    private String p3;
    private String pc;
    private String ir;

    @Override
    public String toString(){
        return p2 + pc  + p3 + "IR" + ir;
    }
}
