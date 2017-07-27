package com.example.demo.common.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.enums.ResultCode;
import com.example.demo.common.util.ErrorCodeMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenovo on 2017/7/27.
 */
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected CommonResponse errorReturn(ResultCode resultCode) {
        return errorReturn(resultCode.code);
    }

    /**
     * 失败返回
     * @param code  code
     * @return  CommonResponse
     */
    @Deprecated
    protected CommonResponse errorReturn(int code) {
        CommonResponse response = new CommonResponse();
        response.setCode(code);
        response.setMessage(ErrorCodeMsgUtil.getMessage(code));
        response.setData(new JSONArray());
        logger.info(response.toString());
        return response;
    }
    protected CommonResponse errorReturn(int code,Object data) {
        CommonResponse response = new CommonResponse();
        response.setCode(code);
        response.setMessage(ErrorCodeMsgUtil.getMessage(code));
        response.setData(data);
        logger.info(response.toString());
        return response;
    }

    /**
     * 成功返回
     * @param data  data
     * @return  CommonResponse
     */
    protected CommonResponse successReturn(Object data) {
        CommonResponse response = new CommonResponse();
        response.setCode(0);
        response.setMessage(ErrorCodeMsgUtil.getMessage(0));
        response.setData(data);
        logger.info(response.toString());
        return response;
    }

    /**
     * 使用此方法确保data中status和error_code有值
     * @param data  data
     * @return  CommonResponse
     */
    protected CommonResponse commonReturn(JSONObject data) {
        CommonResponse response = new CommonResponse();
        response.setCode(Integer.parseInt(data.getString("code")));
        response.setData(data.get("data"));
        response.setMessage(data.getString("message"));
        logger.info(response.toString());
        return response;
    }

    protected CommonResponse commonSuccessReturn(JSONObject data) {
        CommonResponse response = new CommonResponse();
        response.setCode(0);
        response.setData(data);
        response.setMessage(ErrorCodeMsgUtil.getMessage(0));
        logger.info(response.toString());
        return response;
    }

    protected CommonResponse errorReturn(ResultCode resultCode, Object[] args) {
        return errorReturn(resultCode.code, args);
    }
    /**
     * 失败返回
     * @param code  code
     * @param args  args
     * @return  CommonResponse
     */
    @Deprecated
    protected CommonResponse errorReturn(int code, Object[] args) {
        CommonResponse response = new CommonResponse();
        response.setCode(code);
        response.setMessage(ErrorCodeMsgUtil.getMessage(code, args));
        response.setData(new JSONArray());
        logger.info(response.toString());
        return response;
    }

    /**
     * 失败返回
     * @param code      code
     * @param message   message
     * @return  CommonResponse
     */
    protected CommonResponse errorReturn(int code, String message) {
        CommonResponse response = new CommonResponse();
        response.setCode(code);
        response.setMessage(message);
        response.setData(new JSONArray());
        logger.info(response.toString());
        return response;
    }

}
