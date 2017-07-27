package com.example.demo.common.enums;

/**
 * Created by lenovo on 2017/7/26.
 */
public enum DynastyEnum {

    XIA(1,"夏朝","约前2029年-约前1559年");


    private Integer index ;
    private String name;
    private String time;


    private   DynastyEnum(Integer index,String name ,String time){
        this.index = index;
        this.name = name;
        this.time = time;
    }

}
