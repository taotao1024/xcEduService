package com.xuecheng.manage_cms.taskdDemo;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.transform.sax.SAXSource;


//@Component
//串行执行
public class task01 {

    static int i = 1;

    //CROM表达式
    @Scheduled(cron = "0/3 * * * * *")
    public void taks01() {
        System.out.println("==========task01开始==========");
        //System.out.println("CROM : " + "第" + i++ + "个任务");
        System.out.println("==========task01结束==========");
    }

    //任务开始后,3秒执行下一次调度
    @Scheduled(fixedRate = 3000)
    public void taks02() {
        System.out.println("==========task02开始==========");
        //System.out.println("fixedRate : " + "第" + i++ + "个任务");
        System.out.println("==========task02结束==========");
    }

    //任务结束后,3秒执行一下调度
    //@Scheduled(fixedDelay = 3000)
    @Scheduled(fixedRate = 3000)
    public void taks03() {
        System.out.println("==========task03开始==========");
       // System.out.println("fixedDelay : " + "第" + i++ + "个任务");
        System.out.println("==========task03结束==========");
    }
}
