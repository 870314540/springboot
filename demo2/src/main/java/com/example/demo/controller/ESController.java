package com.example.demo.controller;

import com.example.demo.es.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ThomasCui
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
    public @ResponseBody
    String getResult() {
        return esService.getResult();
    }

    @PostMapping("/getResultWithParam")
    public @ResponseBody
    String getResultWithParam(@RequestParam("index") String index,@RequestParam("type")  String type, @RequestParam("id")  String id) {
        return esService.getResult(index, type, id);
    }

    @RequestMapping(value="/{index}/{type}/{id}",method= RequestMethod.GET)
    public @ResponseBody
    String getResultWithpath(@PathVariable("index") String index,@PathVariable("type")  String type, @PathVariable("id")  String id) {
        return esService.getResult(index, type, id);
    }
    @PostMapping("/getResultWithIndex")
    public @ResponseBody
    String getResultWithIndex(@RequestParam("index") String index ) {
        return esService.getResult(index);
    }


}
