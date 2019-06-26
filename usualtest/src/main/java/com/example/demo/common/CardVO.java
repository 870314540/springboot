package com.example.demo.common;

/**
 * @author cuiyt
 * @Descrption
 * @create 2019/4/24
 */
public class CardVO {
    private String name ;
    private Integer sortCode;


    CardVO(String name,Integer sortCode){
        this.name=name;
        this.sortCode=sortCode;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }
}
