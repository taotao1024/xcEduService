package com.xuecheng.framework.domain.learning.respones;

import com.xuecheng.framework.model.response.api.ResultCode;

public enum LearningCode implements ResultCode {
    /**
     * 页面不存在
     */
    LEARNING_GETMEDIA_ERROR(false, 23001, "页面不存在"),
    CHOOSECOURSE_USERISNULL(false, 23002, "用户不存在"),
    CHOOSECOURSE_TASKISNULL(false, 23003, "任务不存在");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private LearningCode(boolean success, int code, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }


    @Override
    public boolean success() {
        return false;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String message() {
        return null;
    }
}
