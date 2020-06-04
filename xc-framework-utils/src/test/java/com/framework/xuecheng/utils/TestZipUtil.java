package com.framework.xuecheng.utils;

import com.xuecheng.framework.utils.ZipUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(value = JUnit4.class)
public class TestZipUtil {

    @Test
    public void testUnZip() throws Exception {
        String zipFilePath = "C:\\Users\\80916\\Desktop\\NotePad++代码格式化插件 NppAStyle.zip";
        String targetPath = "C:\\Users\\80916\\Desktop\\test\\";
        ZipUtil.unzip(zipFilePath, targetPath);
    }
}
