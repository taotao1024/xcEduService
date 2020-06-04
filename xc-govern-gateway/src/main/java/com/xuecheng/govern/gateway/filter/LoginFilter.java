package com.xuecheng.govern.gateway.filter;

import com.alibaba.fastjson.JSON;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.govern.gateway.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前置过滤器
 * <p>
 * 网关只负责拦截认证,判断是否与权利访问.
 *
 * @author yuanYuan
 * @version 1.0
 **/
@Component
public class LoginFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulFilter.class);

    @Autowired
    AuthService authService;

    /**
     * 过虑器的类型
     * pre：请求在被路由之前执行
     * routing：在路由请求时调用
     * post：在routing和errror过滤器之后调用
     * error：处理请求时发生错误调用
     *
     * @return String(过滤类型)
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过虑器序号，越小越被优先执行
     *
     * @return int(多个过滤器的有限期)
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回true表示要执行此过虑器
     *
     * @return boolean(是否执行)
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过虑器逻辑
     * 过虑所有请求，判断头部信息是否有Authorization，如果没有则拒绝访问，否则转发到微服务。
     *
     * @return Object
     * @throws ZuulException 网关异常
     */
    @Override
    public Object run() throws ZuulException {

        //请求体
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //1.取cookie中的身份令牌,证明本地令牌存在
        String token = authService.getTokenFromCookie(request);
        if (StringUtils.isEmpty(token)) {
            this.accessDenied(requestContext);
            LOGGER.info("本地Cookie中身份令牌不存在");
            return null;
        }

        //2.从redis取出jwt的过期时间,证明服务器令牌存在
        long expire = authService.getExpire(token);
        if (expire < 0) {
            this.accessDenied(requestContext);
            LOGGER.info("Redis服务器身份令牌过期");
            return null;
        }

        //3.从header中取jwt,证明存在JWT令牌
        String jwt = authService.getJwtFromHeader(request);
        if (StringUtils.isEmpty(jwt)) {
            this.accessDenied(requestContext);
            LOGGER.info("JWT令牌为空");
            return null;
        }
        return null;
    }


    /**
     * 访问被拒绝,自动以相应信息
     */
    private void accessDenied(RequestContext requestContext) {
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //拒绝访问
        requestContext.setSendZuulResponse(false);
        //设置响应代码
        requestContext.setResponseStatusCode(200);
        //构建响应的信息
        ResponseResult responseResult = new ResponseResult(CommonCode.UNAUTHENTICATED);
        //转成json
        String jsonString = JSON.toJSONString(responseResult);
        //设置响应信息
        requestContext.setResponseBody(jsonString);
        //设置contentType
        response.setContentType("application/json;charset=utf-8");
    }

}
