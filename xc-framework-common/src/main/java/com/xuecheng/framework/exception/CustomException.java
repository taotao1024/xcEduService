package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.api.ResultCode;

/**
 * 自定义运行时异常类型
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/3/24
 */
public class CustomException extends RuntimeException {


    ResultCode resultCode;

    /**
     * 构造方法注入
     * @param resultCode
     */
    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 返回错误代码
     *
     * @return
     */
    public ResultCode getResultCode() {
        return resultCode;
    }

}
