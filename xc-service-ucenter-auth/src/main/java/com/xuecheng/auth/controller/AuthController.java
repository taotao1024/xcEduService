package com.xuecheng.auth.controller;

import com.xuecheng.api.auth.AuthControllerApi;
import com.xuecheng.auth.service.AuthService;
import com.xuecheng.framework.domain.ucenter.ext.AuthToken;
import com.xuecheng.framework.domain.ucenter.request.LoginRequest;
import com.xuecheng.framework.domain.ucenter.response.AuthCode;
import com.xuecheng.framework.domain.ucenter.response.JwtResult;
import com.xuecheng.framework.domain.ucenter.response.LoginResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 认证
 **/
@RestController
@RequestMapping("/")
public class AuthController implements AuthControllerApi {
    /**
     * XcWebApp
     */
    @Value("${auth.clientId}")
    String clientId;

    /**
     * XcWebApp
     */
    @Value("${auth.clientSecret}")
    String clientSecret;

    /**
     * xuecheng.com
     */
    @Value("${auth.cookieDomain}")
    String cookieDomain;

    /**
     * -1 有效期
     */
    @Value("${auth.cookieMaxAge}")
    int cookieMaxAge;

    @Autowired
    AuthService authService;

    /**
     * 登陆
     * @param loginRequest 登陆信息 用户名、密码、验证码
     * @return
     */
    @Override
    @PostMapping("/userlogin")
    public LoginResult login(LoginRequest loginRequest) {
        //参数校验
        if (null == loginRequest || StringUtils.isEmpty(loginRequest.getUsername())) {
            ExceptionCast.cast(AuthCode.AUTH_USERNAME_NONE);
        }
        if (null == loginRequest || StringUtils.isEmpty(loginRequest.getPassword())) {
            ExceptionCast.cast(AuthCode.AUTH_PASSWORD_NONE);
        }
        //账号
        String username = loginRequest.getUsername();
        //密码
        String password = loginRequest.getPassword();

        //申请令牌
        AuthToken authToken = authService.login(username, password, clientId, clientSecret);

        //用户身份令牌 短令牌
        String access_token = authToken.getAccess_token();
        //将令牌存储到cookie
        this.saveCookie(access_token);

        return new LoginResult(CommonCode.SUCCESS, access_token);
    }

    //退出
    @Override
    @PostMapping("/userlogout")
    public ResponseResult logout() {
        //取出身份令牌
        String uid = this.getTokenFormCookie();
        //删除redis中token
        boolean result = authService.delToken(uid);
        //清除cookie
        clearCookie(uid);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /**
     * 通过jti获取令牌
     * @return
     */
    @Override
    @GetMapping("/userjwt")
    public JwtResult userJwt() {
        //获取cookie中的令牌
        String uid = this.getTokenFormCookie();
        if (null == uid) {
            return new JwtResult(CommonCode.FAIL, null);
        }
        //根据令牌从redis查询jwt
        AuthToken authToken = authService.getUserToken(uid);
        if (null == authToken) {
            return new JwtResult(CommonCode.FAIL, null);
        }
        return new JwtResult(CommonCode.SUCCESS, authToken.getJwt_token());
    }


    /**
     * 将令牌存储到cookie
     *
     * @param token 令牌
     */
    private void saveCookie(String token) {
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        CookieUtil.addCookie(response, cookieDomain, "/", "uid", token, cookieMaxAge, false);
    }

    /**
     * 清除cookie,有效期为0
     *
     * @param token
     */
    private void clearCookie(String token) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        CookieUtil.addCookie(response, cookieDomain, "/", "uid", token, 0, false);
    }

    /**
     * 从cookie中读取访问令牌
     *
     * @return uid
     */
    private String getTokenFormCookie() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> cookieMap = CookieUtil.readCookie(request, "uid");
        String result = null;
        if (null != cookieMap && null != cookieMap.get("uid")) {
            result = cookieMap.get("uid");
        }
        return result;
    }

}
