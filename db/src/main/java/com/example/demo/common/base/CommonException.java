package com.example.demo.common.base;

import com.example.demo.common.enums.ResultCode;
import com.example.demo.common.util.ErrorCodeMsgUtil;

/**
 * Created by lenovo on 2017/7/27.
 */
public class CommonException extends  RuntimeException {
    private int code;

    private String message;

    private boolean flag = true;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public CommonException(ResultCode resultCode) {
        this(resultCode.code);
    }

    public CommonException(int code) {
        super(ErrorCodeMsgUtil.getMessage(code));
        this.code = code;
        String message = ErrorCodeMsgUtil.getMessage(code);
        if (message == null || "".equals(message.trim())) {
            this.message = message;
        }

    }

    /**
     *跑到前台的message以及code
     * @param code
     * @param message
     * @author liuzh
     */
    /*public CommonException(int code, String message) {
        this.code = code;
        this.message = message;
    }*/

    public CommonException(int code,Object... args) {
        super(ErrorCodeMsgUtil.getMessage(code, args));
        this.code = code;
        this.flag = true;
        String message = ErrorCodeMsgUtil.getMessage(code, args);
        if (message == null || "".equals(message.trim())) {
            this.message = message;
        }
    }

    public CommonException(ResultCode resultCode, Object... args) {
        this(resultCode.code, args);
    }
}
