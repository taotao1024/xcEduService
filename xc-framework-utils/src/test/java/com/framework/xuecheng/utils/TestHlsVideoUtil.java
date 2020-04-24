package com.framework.xuecheng.utils;

import com.xuecheng.framework.utils.HlsVideoUtil;
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
public class TestHlsVideoUtil {
    @Test
    public static void test() throws IOException {
        String ffmpeg_path = "C:/Program Files/Java/ffmpeg-20180227-fa0c9d6-win64-static/bin//ffmpeg.exe";//ffmpeg的安装位置
        String video_path = "D:\\ffmpeg_server\\templete.mp4";
        String m3u8_name = "templete.m3u8";
        String m3u8_path = "D:\\ffmpeg_server\\develop\\video\\hls\\";
        HlsVideoUtil videoUtil = new HlsVideoUtil(ffmpeg_path, video_path, m3u8_name, m3u8_path);
        String s = videoUtil.generateM3u8();
        System.out.println(s);
        System.out.println(videoUtil.get_ts_list());
    }
}
