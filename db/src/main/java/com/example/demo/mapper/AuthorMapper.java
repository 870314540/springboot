package com.example.demo.mapper;

import com.example.demo.entity.Author;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mybatis 注解版
 */
@Repository
@Mapper
public interface AuthorMapper {
    @Delete({
        "delete from author",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into author (id, author_name, ",
        "gender, destiny, ",
        "lifetime)",
        "values (#{id,jdbcType=INTEGER}, #{authorName,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=INTEGER}, #{destiny,jdbcType=VARCHAR}, ",
        "#{lifetime,jdbcType=VARCHAR})"
    })
    int insert(Author record);

    @InsertProvider(type=AuthorSqlProvider.class, method="insertSelective")
    int insertSelective(Author record);

    @Select({
        "select",
        "id, author_name, gender, destiny, lifetime",
        "from author",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="author_name", property="authorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="destiny", property="destiny", jdbcType=JdbcType.VARCHAR),
        @Result(column="lifetime", property="lifetime", jdbcType=JdbcType.VARCHAR)
    })
    Author selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, author_name, gender, destiny, lifetime",
            "from author"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="author_name", property="authorName", jdbcType=JdbcType.VARCHAR),
            @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
            @Result(column="destiny", property="destiny", jdbcType=JdbcType.VARCHAR),
            @Result(column="lifetime", property="lifetime", jdbcType=JdbcType.VARCHAR)
    })
    List<Author> getAll();



    @UpdateProvider(type=AuthorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Author record);

    @Update({
        "update author",
        "set author_name = #{authorName,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "destiny = #{destiny,jdbcType=VARCHAR},",
          "lifetime = #{lifetime,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Author record);
}