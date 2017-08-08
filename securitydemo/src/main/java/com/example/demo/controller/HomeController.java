package com.example.demo.controller;

import com.example.demo.controller.vo.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2017/8/1.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("标题", "内容", "我");
        model.addAttribute("msg", msg);
        return "index";
    }
}