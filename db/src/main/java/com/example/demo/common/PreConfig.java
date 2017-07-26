package com.example.demo.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by lenovo on 2017/7/26.
 */
@ConfigurationProperties(prefix = "pre")
public class PreConfig {
    private String name;
    private String code;
    private List<String> list;

    public String getName() {
        return name;
    }



    public String getCode() {
        return code;
    }


    public List<String> getList() {
        return list;
    }

}
