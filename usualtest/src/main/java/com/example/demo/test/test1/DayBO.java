package com.example.demo.test.test1;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/8/28
 */
public class DayBO implements Serializable {
    int id ;
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
