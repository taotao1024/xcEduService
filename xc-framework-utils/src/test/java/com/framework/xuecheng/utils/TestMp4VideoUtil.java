package com.framework.xuecheng.utils;

import com.xuecheng.framework.utils.Mp4VideoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/24
 */
@RunWith(value = JUnit4.class)
public class TestMp4VideoUtil {

    @Test
    public static void test() throws IOException {
        String ffmpeg_path = "C:/Program Files/Java/ffmpeg-20180227-fa0c9d6-win64-static/bin//ffmpeg.exe";
        String video_path = "D:\\ffmpeg_server\\templete.mp4";
        String mp4_name = "templete_cmd.mp4";
        String mp4_path = "C:\\Users\\80916\\Desktop\\";
        Mp4VideoUtil videoUtil = new Mp4VideoUtil(ffmpeg_path, video_path, mp4_name, mp4_path);
        String s = videoUtil.generateMp4();
        System.out.println(s);
    }
}
