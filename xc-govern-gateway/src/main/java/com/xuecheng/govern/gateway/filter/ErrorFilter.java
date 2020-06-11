package com.xuecheng.govern.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * Error过滤器统计
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/5/15
 */
@Component
public class ErrorFilter extends ZuulFilter {

    private static int errorCount = 0;

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        errorCount = ++errorCount;
        System.out.println("ErrorZuul调用次数：" + errorCount);
        return null;
    }
}
