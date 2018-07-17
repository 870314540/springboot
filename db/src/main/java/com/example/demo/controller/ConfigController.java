package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/7/27.
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Value("${pre.name}")
    private String myname;
    @RequestMapping("/name")
    public String getConfig() {
         return myname;
    }
}
