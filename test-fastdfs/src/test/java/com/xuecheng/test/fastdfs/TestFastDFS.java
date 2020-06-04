package com.xuecheng.test.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试fastdfs
 **/
@SpringBootTest
//@RunWith(SpringRunner.class)
@RunWith(JUnit4.class)
public class TestFastDFS {

    //上传文件
    @Test
    public void testUpload() {
        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient，用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建stroageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, storeStorage);
            //向stroage服务器上传文件
            //本地文件的路径
            String filePath = "D:/IDEA-workSpace/FastDFS/cat.jpg";
            //上传成功后拿到文件Id
            String fileId = storageClient1.upload_file1(filePath, "png", null);
            System.out.println(fileId);
            System.out.println("上传成功");
            //group1/M00/00/00/rBAVnV5dUaqAJiNiAA7J3UwW8F4721.png
            //group1/M00/00/00/rBAVnV7LoBuAEY39AA7J3UwW8F4569.png
            //http://120.79.134.119/group1/M00/00/00/rBAVnV5dUaqAJiNiAA7J3UwW8F4721.png
            trackerServer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //下载文件
    @Test
    public void testDownload() {
        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient，用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建stroageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, storeStorage);
            //下载文件
            //文件id
            String fileId = "group1/M00/00/00/rBAVnV5dUaqAJiNiAA7J3UwW8F4721.png";
            byte[] bytes = storageClient1.download_file1(fileId);
            //使用输出流保存文件
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\Public\\Desktop\\"));
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void test() {
        int result = 0;
        result += 2;
        System.out.println("Result+=2的结果是" + result);

        int a = 0;
        a = a + 2;
        System.out.println("a=a+2的结果是" + a);
    }

    @Test
    public void test1() {
        int day = 3;
        int result = 0, cnt = 0;
        for (int i = 1; i <= day; i++) {
            for (int j = 0; j < i; j++) {
                result += i;
                cnt++;
                if (cnt == day) break;
            }
            if (cnt == day) break;
        }
        System.out.println(result);
    }

    @Test
    public void testEqu() {
        String []a = new String[10];
        System.err.println(a[2]);
        System.err.println(a.length);

    }
}
