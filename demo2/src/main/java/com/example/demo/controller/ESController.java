package com.example.demo.controller;

import com.example.demo.es.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;

/**
 * @author cuiyt
 * @Descrption
 * @create 2018/7/17
 */
@Controller
public class ESController {
    @Autowired
    private ESService esService;
    @RequestMapping("/")
    public String getResult() {
        return esService.getResult();
    }
}
