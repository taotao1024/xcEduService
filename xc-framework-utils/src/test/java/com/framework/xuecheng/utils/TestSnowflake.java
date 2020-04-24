package com.framework.xuecheng.utils;

import com.xuecheng.framework.utils.Snowflake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.temporal.JulianFields;

/**
 * TODO
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/24
 */
@RunWith(value = JUnit4.class)
public class TestSnowflake {
    @Test

    public static void test() {
        Snowflake idWorker = new Snowflake(1, 2);
        Snowflake idWorker2 = new Snowflake(1, 3);
        for (int i = 0; i < 10; i++) {
            long l = idWorker.nextId();
            long l2 = idWorker2.nextId();
            System.out.println(l);
            System.out.println(l2);
        }

    }
}
