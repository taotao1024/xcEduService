package com.xuecheng.govern.gateway.service;

import com.xuecheng.framework.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 认证服务层
 *
 * @author yuanYuan
 * @version 1.0
 **/
@Service
public class AuthService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 从请求头中取出jwt令牌
     *
     * @param request HttpServletRequest
     * @return "Authorization":"Bearer abc"中的abc,其中abc为令牌串
     */
    public String getJwtFromHeader(HttpServletRequest request) {
        String result;
        String authorizationValueHead = "Bearer ";
        //取出头信息
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            return null;
        }
        if (!authorization.startsWith(authorizationValueHead)) {
            return null;
        }
        //取到jwt令牌
        result = authorization.substring(7);
        return result;
    }

    /**
     * 查询身份令牌
     * 从cookie取出token
     *
     * @param request HttpServletRequest
     * @return 令牌串 uid.value
     */
    public String getTokenFromCookie(HttpServletRequest request) {
        Map<String, String> cookieMap = CookieUtil.readCookie(request, "uid");
        String result = cookieMap.get("uid");
        if (StringUtils.isEmpty(result)) {
            return null;
        }
        return result;
    }

    /**
     * 查询令牌的有效期
     *
     * @param accessToken 访问令牌
     * @return
     */
    public long getExpire(String accessToken) {
        String key = "user_token:" + accessToken;
        long result = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
        return result;
    }
}
