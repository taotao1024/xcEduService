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
 * 认证
 **/
@Service
public class AuthService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 从请求头中取出jwt令牌
     *
     * @param request HttpServletRequest
     * @return
     */
    public String getJwtFromHeader(HttpServletRequest request) {
        //取出头信息
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            return null;
        }
        if (!authorization.startsWith("Bearer ")) {
            return null;
        }
        //取到jwt令牌
        String result = authorization.substring(7);
        return result;
    }

    /**
     * 查询身份令牌
     * 从cookie取出token
     *
     * @param request HttpServletRequest
     * @return token串
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
     * @param access_token Token串
     * @return
     */
    public long getExpire(String access_token) {
        String key = "user_token:" + access_token;
        Long result = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
        return result;
    }
}
