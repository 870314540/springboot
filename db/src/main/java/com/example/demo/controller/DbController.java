package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.IAutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/7/26.
 */
@RestController
@RequestMapping("/user")
public class DbController {
    @Autowired
    private IAutherService iAutherService ;
    /**
     * 获取数据库列表
     */

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public Author view(@PathVariable("id") Integer id) {
        Author user = new Author();
        user = iAutherService.getAuthorById(id);
        return user;
    }
}
