package com.xuecheng.manage_cms.dao;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFSTest {
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;

    //上传文件
    @Test
    public void testAddGridFS() throws FileNotFoundException {
        File file = new File("D:\\IDEA-workSpace\\xcEduUI\\static\\course.ftl");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectId objectId = gridFsTemplate.store(fileInputStream, "course.ftl");
        System.out.println(objectId);
        //5d3226cc3b5dba4d40923f03  ----  index_banner.ftl
        //5e5fa55bbeae273f24c6b59d  ----  course.ftl
    }

    //下载文件
    @Test
    public void testDownload() throws IOException {
        //根据id查询文件
        GridFSFile id = gridFsTemplate.findOne(new Query(Criteria.where("_id").is("5d3226cc3b5dba4d40923f03")));
        //打开下载流
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(id.getObjectId());
        //下载流操作对象
        GridFsResource gridFsResource = new GridFsResource(id, gridFSDownloadStream);
        //从流中获取数据
        String s = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");
        System.out.println(s);
    }

    //删除文件
    @Test
    public void testDelete() {
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is("5d3226cc3b5dba4d40923f03")));
    }

}
