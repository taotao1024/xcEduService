package com.xuecheng.test.freemarker;

import com.xuecheng.test.freemarker.model.Student;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.*;
import java.util.*;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-06-13 10:07
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class FreemarkerTest {

    //基于模板生成静态化文件
    @Test
    public void testGenerateHtml() throws IOException, TemplateException {
        //创建配置类
        Configuration configuration = new Configuration(Configuration.getVersion());
        //获取当前classpath路径
        String classpath = this.getClass().getResource("/").getPath();
        //设置模板路径
        configuration.setDirectoryForTemplateLoading(new File(classpath + "/templates/"));
        //设置字符集
        configuration.setDefaultEncoding("utf-8");
        //加载模板
        Template template = configuration.getTemplate("test1.ftl");
        //数据模型
        Map map = getMap();
        //静态化
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        //静态化内容
        System.out.println(content);
        //输入流
        InputStream inputStream = IOUtils.toInputStream(content);
        //输出流
        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/freemarker/test1.html"));
        int copy = IOUtils.copy(inputStream, fileOutputStream);
    }

    //基于模板字符串生成静态化文件
    @Test
    public void testGenerateHtmlByString() throws IOException, TemplateException {
        //创建配置类
        Configuration configuration = new Configuration(Configuration.getVersion());
        //获取模板内容
        //模板内容，这里测试时使用简单的字符串作为模板
        String templateString = "" +
                "<html>\n" +
                "    <head></head>\n" +
                "    <body>\n" +
                "    名称：${name}\n" +
                "    </body>\n" +
                "</html>";
        //加载模板
        //模板加载器
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        //模板加载器 将字符串转换为模板
        stringTemplateLoader.putTemplate("template", templateString);
        //设置模板加载器
        configuration.setTemplateLoader(stringTemplateLoader);
        //获取模板内容并设置字符编码
        Template template = configuration.getTemplate("template", "utf-8");
        //数据模型
        Map map = getMap();
        //静态化
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        //静态化内容
        System.out.println(content);
        InputStream inputStream = IOUtils.toInputStream(content);
        //输出文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/freemarker/test2.html"));
        IOUtils.copy(inputStream, fileOutputStream);
    }

    //数据模型
    private Map getMap() {
        Map<String, Object> map = new HashMap<>();
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

        return map;
    }
}
