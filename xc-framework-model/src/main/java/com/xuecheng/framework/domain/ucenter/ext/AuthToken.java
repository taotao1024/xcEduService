package com.xuecheng.framework.domain.ucenter.ext;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 认证令牌
 */
@Data
@ToString
@NoArgsConstructor
public class AuthToken {
    /**
     * 访问token
     */
    String access_token;
    /**
     * 刷新token
     */
    String refresh_token;
    /**
     * jwt令牌
     */
    String jwt_token;
}
