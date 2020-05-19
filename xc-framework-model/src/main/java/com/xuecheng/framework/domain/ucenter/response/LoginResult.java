package com.xuecheng.framework.domain.ucenter.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.api.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
public class LoginResult extends ResponseResult {
    public LoginResult(ResultCode resultCode,String token) {
        super(resultCode);
        this.token = token;
    }
    private String token;
}
