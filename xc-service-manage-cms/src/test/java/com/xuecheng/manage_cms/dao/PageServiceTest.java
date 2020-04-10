package com.xuecheng.manage_cms.dao;

import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageServiceTest {
    @Autowired
    PageService pageService;

    @Test
    public void getPageHtmlTest() {
        String html = pageService.getPageHtml("5a795ac7dd573c04508f3a56");
        System.out.println(html);
    }
    @Test
    public void getModelByPageId() {
        Map html = pageService.getModelByPageId("5a795ac7dd573c04508f3a56");
        System.out.println(html);
    }

}
