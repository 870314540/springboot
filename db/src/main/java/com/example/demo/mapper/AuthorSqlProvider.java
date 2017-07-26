package com.example.demo.mapper;

import com.example.demo.entity.Author;
import org.apache.ibatis.jdbc.SQL;

public class AuthorSqlProvider {

    public String insertSelective(Author record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("author");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getAuthorName() != null) {
            sql.VALUES("author_name", "#{authorName,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            sql.VALUES("gender", "#{gender,jdbcType=INTEGER}");
        }
        
        if (record.getDestiny() != null) {
            sql.VALUES("destiny", "#{destiny,jdbcType=VARCHAR}");
        }
        
        if (record.getLifetime() != null) {
            sql.VALUES("lifetime", "#{lifetime,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Author record) {
        SQL sql = new SQL();
        sql.UPDATE("author");
        
        if (record.getAuthorName() != null) {
            sql.SET("author_name = #{authorName,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            sql.SET("gender = #{gender,jdbcType=INTEGER}");
        }
        
        if (record.getDestiny() != null) {
            sql.SET("destiny = #{destiny,jdbcType=VARCHAR}");
        }
        
        if (record.getLifetime() != null) {
            sql.SET("lifetime = #{lifetime,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}