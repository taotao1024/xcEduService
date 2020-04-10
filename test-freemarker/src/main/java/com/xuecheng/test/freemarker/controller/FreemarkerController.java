package com.xuecheng.test.freemarker.controller;

import com.xuecheng.test.freemarker.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-06-12 18:40
 **/
@RequestMapping("/freemarker")
@Controller
public class FreemarkerController {
    @Autowired
    RestTemplate restTemplate;

    //课程详情页面测试
    @RequestMapping("/course")
    public String course(Map<String, Object> map) {
        String url = "http://localhost:31200/course/courseview/4028e581617f945f01617f9dabc40000";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);
        Map body = forEntity.getBody();
        map.putAll(body);
        return "course";
    }

    //轮播图页面测试
    @RequestMapping("/banner")
    public String index_banner(Map<String, Object> map) {
        String dataUrl = "http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        Map body = forEntity.getBody();
        map.put("model", body);
        return "index_banner";
    }

    @RequestMapping("/freemarkerTest")
    public String freemarker(Map<String, Object> map) {
        //向数据模型放数据
        map.put("name", "java程序员");
        //学生数据
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(18);
        stu1.setMondy(1000.86f);
        stu1.setBirthday(new Date());
        //学生数据
        Student stu2 = new Student();
        stu2.setName("李四");
        stu2.setMondy(200.1f);
        stu2.setAge(19);
        stu2.setBirthday(new Date());
        //学生列表
        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);

        //好朋友列表
        List<Student> friends = new ArrayList<>();
        friends.add(stu1);
        //stu2的好盆朋友列表
        stu2.setFriends(friends);
        //stu2的最好的盆友
        stu2.setBestFriend(stu1);

        //向数据模型放数据
        map.put("stus", stus);

        //准备map数据
        HashMap<String, Student> stuMap = new HashMap<>();
        stuMap.put("stu1", stu1);
        stuMap.put("stu2", stu2);
        //向数据模型放数据
        map.put("stu1", stu1);
        //向数据模型放数据
        map.put("stuMap", stuMap);

        //返回模板文件
        return "FreemarkerTest";
    }
}
