package com.xuecheng.framework.model.response.api;

/**
 * 系统响应结果码
 * <p>
 * succes 是否成功
 * <p>
 * code 返回码
 * <p>
 * message 返回描述信息
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/3/24
 */
public interface ResultCode {
    /**
     * 操作是否成功
     *
     * @return true为成功，false操作失败
     */
    boolean success();

    /**
     * 操作代码
     *
     * <p>
     * 10000-- 通用错误代码
     * <p>
     * 22000-- 媒资错误代码
     * <p>
     * 23000-- 用户中心错误代码
     * <p>
     * 24000-- CMS错误代码
     * <p>
     * 25000-- 文件系统
     *
     * @return int常量
     */
    int code();

    /**
     * 提示信息
     *
     * @return String字符串
     */
    String message();

}
