package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

//自定义异常类型
public class CustomException extends RuntimeException {

    //错误代码
    ResultCode resultCode;

    //构造方法注入
    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 返回错误代码
     * @return
     */
    public ResultCode getResultCode() {
        return resultCode;
    }


}
