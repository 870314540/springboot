package com.example.demo.controller;

import com.example.demo.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/5/30
 */
@Controller
public class TestController {


    @Autowired
    private IHelloService helloService;

    @PostMapping("/name")
    public @ResponseBody
    String getConfig() {

        return "hello";
    }

    @PostMapping("/run")
    public @ResponseBody
    String runPrint() throws InterruptedException {
        helloService.circlePrint();

        return "hello1";
    }

    @PostMapping("/modifyValue")
    public @ResponseBody
    String modifyValue(int value) {
        helloService.modifyValue(value);
        return "hello2";
    }

    @PostMapping("/getValue")
    public @ResponseBody
    Integer getValue() {

        return  helloService.getValue();
    }
}
