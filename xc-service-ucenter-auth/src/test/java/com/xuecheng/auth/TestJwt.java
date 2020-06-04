package com.xuecheng.auth;

import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试JWT令牌
 **/
@SpringBootTest
//@RunWith(SpringRunner.class)
@RunWith(JUnit4.class)
public class TestJwt {

    static String jwtResult="";

    /**
     * 创建jwt令牌
     */
    @Test
    public void testCreateJwt() {
        //密钥库文件
        String keystore = "xc.keystore";
        //密钥库的密码
        String keystore_password = "xuechengkeystore";
        //密钥库文件路径
        ClassPathResource classPathResource = new ClassPathResource(keystore);
        //密钥别名
        String alias = "xckey";
        //密钥的访问密码
        String key_password = "xuecheng";
        //密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource, keystore_password.toCharArray());
        //密钥对（公钥和私钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, key_password.toCharArray());
        //获取私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //jwt令牌的内容
        Map<String, String> body = new HashMap<>();
        body.put("name", "testJWTCreate");
        body.put("User", "testUser");
        String bodyString = JSON.toJSONString(body);
        //生成jwt令牌 内容为json串 签名为RSA非对称算法
        Jwt jwt = JwtHelper.encode(bodyString, new RsaSigner(aPrivate));
        //生成jwt令牌编码
        String encoded = jwt.getEncoded();
        this.jwtResult=encoded;
        System.out.println(encoded);

    }

    /**
     * 校验jwt令牌
     */
    @Test
    public void testVerify() {
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnASXh9oSvLRLxk901HANYM6KcYMzX8vFPnH/To2R+SrUVw1O9rEX6m1+rIaMzrEKPm12qPjVq3HMXDbRdUaJEXsB7NgGrAhepYAdJnYMizdltLdGsbfyjITUCOvzZ/QgM1M4INPMD+Ce859xse06jnOkCUzinZmasxrmgNV3Db1GtpyHIiGVUY0lSO1Frr9m5dpemylaT0BV3UwTQWVW9ljm6yR3dBncOdDENumT5tGbaDVyClV0FEB1XdSKd7VjiDCDbUAUbDTG1fm3K9sx7kO1uMGElbXLgMfboJ963HEJcU01km7BmFntqI5liyKheX+HBUCD4zbYNPw236U+7QIDAQAB-----END PUBLIC KEY-----";
        //jwt令牌
        String jwtString=this.jwtResult;
        //解码和验证
        Jwt jwt = JwtHelper.decodeAndVerify(jwtString, new RsaVerifier(publickey));
        //拿到jwt令牌中自定义的内容
        String claims = jwt.getClaims();
        System.out.println(claims);
    }

    @Test
    @Ignore
    public void split() {

        String jwtString = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiaXRjYXN0In0.1QOqL1s4DpDHROUAibkz6EMf6hcM7HmTPgmg-SlkacVoQAV7y3XQ7LXxiua6SJlN_uNX_EFjzIshEg_kyy972DtymtRMc2NIO5HzIF5I4oQCxNPsJdhu6qQni6sTas3q0JbAarMZSajDX7HhzVSYWPQJCussA4e1r9oFxDcoAo6TEAXOW8gRHzNIygQz1yCj6mdf4UOHI070kRy7f3BdhmrUJdOuDIMoRBYS4WsEOibAU1UCNPaJAXpZC0ihrtdY7SCg1N43fimeFOHrfpLb6OmRF7v7uvGMgrhg9JIYDbJ6nbode5OJkNceRx8QUICre2yKAe0ctlvXO0REf6OpRA";
        this.splitAndToString(jwtString, "\\.");

        String s1 = "111-222-333-444-555";
        this.splitAndToString(s1, "-");

        String s2 = "111|222|333|444|555";
        this.splitAndToString(s2, "\\|");
    }

    private void splitAndToString(String s, String c) {
        String[] split = s.split(c);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i].toString());
        }
        System.out.println("----------------- 我是分割线 -----------------");
    }
}
