package com.framework.xuecheng.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;

import static com.xuecheng.framework.utils.MD5Util.*;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/24
 */
@RunWith(value = JUnit4.class)
public class TestMD5Util {

    @Test
    public static void test() {

        long beginTime = System.currentTimeMillis();
        File fileZIP = new File("D:\\BaiduNetdiskDownload\\test1.avi");

        String md5 = "";
        try {
            md5 = getFileMD5String(fileZIP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("MD5:" + md5 + "\n time:" + ((endTime - beginTime)) + "ms");

        System.out.println(getStringMD5("111111"));
    }
}
