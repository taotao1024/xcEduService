package com.xuecheng.framework.model.response;

import com.xuecheng.framework.model.response.api.Response;
import com.xuecheng.framework.model.response.api.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 数据响应对象实现类
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/3/24
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseResult implements Response {

    /**
     * 操作是否成功
     */
    boolean success = SUCCESS;

    /**
     * 操作代码
     */
    int code = SUCCESS_CODE;

    /**
     * 提示信息
     */
    String message;

    /**
     * 构造函数
     *
     * @param resultCode 系统响应信息
     */
    public ResponseResult(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResult SUCCESS() {
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public static ResponseResult FAIL() {
        return new ResponseResult(CommonCode.FAIL);
    }

}
