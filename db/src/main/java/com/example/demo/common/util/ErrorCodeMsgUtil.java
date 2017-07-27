package com.example.demo.common.util;

import java.text.MessageFormat;

/**
 * Created by lenovo on 2017/7/27.
 */
public class ErrorCodeMsgUtil {
    private final static String ERROR_CODE_MSG_CONFIG_PATH = "/errorcode_msg_zh.properties";

    /**
     * 获取code 对应
     * @param code  code
     * @return  error message
     */
    public static String getMessage(int code) {
        return PropertiesUtil.getPropValAsString("app.errcode." + code,
                ERROR_CODE_MSG_CONFIG_PATH);
    }

    /**
     * 获取code 对应并传参
     * @param code  code
     * @return  error message
     */
    public static String getMessage(int code, Object... args) {
        String template = PropertiesUtil.getPropValAsString("app.errcode." + code,
                ERROR_CODE_MSG_CONFIG_PATH);
        return MessageFormat.format(template, args);
    }
}
