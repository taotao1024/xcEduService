package com.xuecheng.framework.model.response;

import com.xuecheng.framework.model.response.api.ResultCode;

/**
 * 数据响应对象
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/3/24
 */
public enum CommonCode implements ResultCode {
    /**
     * 非法参数
     */
    INVALID_PARAM(false, 10003, "非法参数！"),
    /**
     * 操作成功
     */
    SUCCESS(true, 10000, "操作成功！"),
    /**
     * 操作失败
     */
    FAIL(false, 11111, "操作失败！"),
    /**
     * 此操作需要登陆系统
     */
    UNAUTHENTICATED(false, 10001, "此操作需要登陆系统！"),
    /**
     * 权限不足，无权操作
     */
    UNAUTHORISE(false, 10002, "权限不足，无权操作"),
    /**
     * 抱歉，系统繁忙，请稍后重试
     */
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");
    /**
     * 操作是否成功
     */
    boolean success;
    /**
     * 操作代码
     */
    int code;
    /**
     * 提示信息
     */
    String message;

    /**
     * 构造函数
     *
     * @param success 操作是否成功
     * @param code    操作代码
     * @param message 提示信息
     */
    CommonCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }


    @Override
    public String toString() {
        return "CommonCode{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}
