package com.xuecheng.framework.utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * ZIP工具
 *
 * @author yuanYuan
 * @version 1.0
 * @date
 */
public class ZipUtil {

    /**
     * 解压zip文件
     *
     * @param zipFilePath ZIP文件路径
     * @param targetPath  解压后目标文件路径
     * @throws ZipException 解压异常
     */
    public static void unzip(String zipFilePath, String targetPath) throws Exception {
        ZipFile zipFile = new ZipFile(zipFilePath);
        zipFile.extractAll(targetPath);
    }

    /**
     * 解压zip文件（带密码）
     *
     * @param zipFilePath ZIP文件路径
     * @param targetPath  解压后目标文件路径
     * @param password    解压密码
     * @throws ZipException 解压异常
     */
    public static void unzip(String zipFilePath, String password, String targetPath) throws Exception {
        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
        }
        zipFile.extractAll(targetPath);
    }
}
