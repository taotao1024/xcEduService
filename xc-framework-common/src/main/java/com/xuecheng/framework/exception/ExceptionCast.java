package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

//抛出异常类
public class ExceptionCast {
    /**
     * 获取异常信息
     * @param resultCode
     */
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
