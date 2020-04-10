package com.xuecheng.auth;

import com.xuecheng.framework.client.XcServiceList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

/**
 * 测试客户端
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestClient {

    /**
     * 客户端负载均衡器
     */
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    /**
     * 远程请求spring security获取令牌
     */
    @Test
    public void testClient() {
        //从eureka中获取认证服务的地址（因为spring security在认证服务中）
        //从eureka中获取认证服务的一个实例的地址
        ServiceInstance serviceInstance = loadBalancerClient.choose(XcServiceList.XC_SERVICE_UCENTER_AUTH);
        //此地址就是http://ip:port
        URI uri = serviceInstance.getUri();
        //令牌申请的地址 http://localhost:40400/auth/oauth/token
        String authUrl = uri + "/auth/oauth/token";

        //定义header
        LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        String httpBasic = getHttpBasic("XcWebApp", "XcWebApp");
        header.add("Authorization", httpBasic);

        //定义body
        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "password");
        body.add("username", "itcast");
        body.add("password", "123");

        //String url, HttpMethod method, @Nullable HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, header);

        //设置restTemplate远程调用时候，对400和401不让报错，正确返回数据
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400 && response.getRawStatusCode() != 401) {
                    super.handleError(response);
                }
            }
        });
        //发送http请求
        ResponseEntity<Map> exchange = restTemplate.exchange(authUrl, HttpMethod.POST, httpEntity, Map.class);

        //申请令牌信息
        Map bodyMap = exchange.getBody();
        System.out.println(bodyMap);
        //{access_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55SWQiOm51bGwsInVzZXJwaWMiOm51bGwsInVzZXJfbmFtZSI6Iml0Y2FzdCIsInNjb3BlIjpbImFwcCJdLCJuYW1lIjpudWxsLCJ1dHlwZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MTU4NTU5NzU2OCwianRpIjoiNDQ3NGM3MzctNzAyNi00Mzc0LTgwZDItMGUyN2IyNGM5NmM0IiwiY2xpZW50X2lkIjoiWGNXZWJBcHAifQ.m9UglHQc81njRTSN8P99uzRB-xrYIYdTJMkkySZwn0ESBp5Sx7pTl139zQ59G0Y4ZzrgT9HuHchVjKSffbthXYiEugE0gEQPlXk2ZgOO_Ob7kzWwIT0PygJMDtmTcogd5Foj2arzUnOYapfDF3LCshLUUZCqutqveYFRr3tCppRa1Wy3m8qCPfABjxR5VmwhqArDU4Lq6_72MkI5xOQ957Hs0Dny1SiDv7yIRirv5OSZFFXUnhX65dhDWmxybYAynSvb62m3GBWi-yiU9K_D5jNGC35Rs4JaV6wIN0Ex0vJpjSbK2gcc1EGNRk69VxcpsMZxUoNOO0OP99cAkRsiPg, token_type=bearer, refresh_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55SWQiOm51bGwsInVzZXJwaWMiOm51bGwsInVzZXJfbmFtZSI6Iml0Y2FzdCIsInNjb3BlIjpbImFwcCJdLCJhdGkiOiI0NDc0YzczNy03MDI2LTQzNzQtODBkMi0wZTI3YjI0Yzk2YzQiLCJuYW1lIjpudWxsLCJ1dHlwZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MTU4NTU5NzU2OCwianRpIjoiODNlZmU4NmMtODk2Yy00MjYwLWE1NWQtZWQ1YmMyN2ZhNjhmIiwiY2xpZW50X2lkIjoiWGNXZWJBcHAifQ.WMnaloDadP87L2TQJu7WlUpfhwnovaCZ9bZrhkrgEtPv1Hp5Y7Xkjlp7s8siGW1e9XUmotTO5bmhPWajeI8e6AGrhCoLUP-0J8xDpF6xQf_7faXeJR6W0sLM1cicNS12BWwQwmPLaqUx_9ZMM927zYxJuJU-QhjgNF3sSR4EtS24qLLigvdHst9skBs1rxG0WfCahbwP90i2tPZUetvW6kDk0o5DTKsTFgVv8tScX-_v_R8wDN2I6croO6uXe6eP8nFX12nPL3yBOg6Bs9ojFxN0VlnLTbvztjJQwsc2JNcBunuxMkQsN-YjXOtLCth1MZnb610q5nJ918IAe3zOLw, expires_in=43199, scope=app, jti=4474c737-7026-4374-80d2-0e27b24c96c4}
    }

    /**
     * 获取httpbasic的串
     *
     * @param clientId     id
     * @param clientSecret 密码
     * @return
     */
    private String getHttpBasic(String clientId, String clientSecret) {
        String string = clientId + ":" + clientSecret;
        //将串进行base64编码
        byte[] encode = Base64Utils.encode(string.getBytes());
        StringBuffer basic_ = new StringBuffer("Basic ");
        StringBuffer result = basic_.append(new String(encode));
        return result.toString();
    }

}
