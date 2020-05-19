package com.xuecheng.govern.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * Rout过滤器统计
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/5/15
 */
@Component
public class CountFilter extends ZuulFilter {

    private static int routeCount = 0;

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        routeCount = ++routeCount;
        System.out.println("RouteZuul调用次数：" + routeCount);
        return null;
    }
}
