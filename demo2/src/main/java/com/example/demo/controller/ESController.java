package com.example.demo.controller;

import com.example.demo.es.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/7/17
 */
@Controller
public class ESController {
    @Autowired
    private ESService esService;

    @Value("123")
    private String myname;

    @PostMapping("/name")
    public @ResponseBody
    String getConfig() {
        return myname;
    }


    @PostMapping("/getResult")
    public @ResponseBody String getResult() {
        return esService.getResult();
    }
}
