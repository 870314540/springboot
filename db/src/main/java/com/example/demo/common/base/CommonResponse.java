package com.example.demo.common.base;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by lenovo on 2017/7/27.
 */
public class CommonResponse<T> {

//    失败：
//    {"status":"failure","code":10001,"message":"this is a error","data":[]}
//    成功：【键值对】
//    {"status":"success","code":0,"message":"","data":{"COLUMN1":"I AM A STRING","COLUMN2":"I AM ALSO A STRING"}}
//    成功：【单值】
//    {"status":"success","code":0,"message":"","data":["I AM A STRING"]}
//    成功：【数组】
//    {"status":"success","code":0,"message":"","data":[{"COLUMN1.1":"STRING1.1","COLUMN1.2":"STRING1.2"},{"COLUMN2.1":"STRING1.1","COLUMN2.2":"STRING2.2"}]}


    private int code = 0;
    private String message = "成功";

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int errorCode) {
        this.code = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String errorMessage) {
        this.message = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        //return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        JSONObject errorJson = new JSONObject();
        errorJson.put("data", this.data);
        errorJson.put("message", message);
        errorJson.put("code", code);
        return errorJson.toString();
    }
}
