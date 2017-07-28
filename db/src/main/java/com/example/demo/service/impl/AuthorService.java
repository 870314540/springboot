package com.example.demo.service.impl;

import com.example.demo.entity.Author;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.service.IAutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/7/26.
 */
@Service
public class AuthorService  implements IAutherService{

    @Autowired
    private AuthorMapper authorMapper ;
    //@Cacheable(value="authorList",keyGenerator = "wiselyKeyGenerator")
    public List<Author> authorList(){
         List<Author> authorList = authorMapper.getAll();
        return  authorList;
     }

    public Author getAuthorById(Integer id){
        Author author= authorMapper.selectByPrimaryKey(id);
        return author;
    }
}
