package com.xuecheng.framework.utils;

import com.xuecheng.framework.bean.UserJwt;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 解析JWT令牌工具类
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/10
 */
public class XcOauth2Util {
    /**
     * 用户id
     */
    String id = "id";

    /**
     * 获取用户信息
     *
     * @param request
     * @return
     */
    public UserJwt getUserJwtFromHeader(HttpServletRequest request) {

        Map<String, String> jwtClaims = Oauth2Util.getJwtClaimsFromHeader(request);
        if (jwtClaims == null || StringUtils.isEmpty(jwtClaims.get(this.id))) {
            return null;
        }
        UserJwt userJwt = new UserJwt();
        userJwt.setId(jwtClaims.get("id"));
        userJwt.setName(jwtClaims.get("name"));
        userJwt.setCompanyId(jwtClaims.get("companyId"));
        userJwt.setUtype(jwtClaims.get("utype"));
        userJwt.setUserpic(jwtClaims.get("userpic"));
        return userJwt;
    }

}
