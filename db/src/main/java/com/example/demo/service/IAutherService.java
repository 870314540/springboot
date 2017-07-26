package com.example.demo.service;

import com.example.demo.entity.Author;

import java.util.List;

/**
 * Created by lenovo on 2017/7/26.
 */
public interface IAutherService {
    public List<Author> authorList();
    public Author getAuthorById(Integer id);
}
