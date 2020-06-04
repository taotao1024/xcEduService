package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.api.ResultCode;


/**
 * 抛出异常类
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/3/24
 */
public class ExceptionCast {
    /**
     * 获取异常信息
     *
     * @param resultCode 结果
     */
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
