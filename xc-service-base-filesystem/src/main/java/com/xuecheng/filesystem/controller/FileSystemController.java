package com.xuecheng.filesystem.controller;

import com.xuecheng.api.filesystem.FileSystemControllerApi;
import com.xuecheng.filesystem.service.FileSystemService;
import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 文件系统
 * @version 1.0
 **/
@RestController
@RequestMapping("/filesystem")
public class FileSystemController implements FileSystemControllerApi {
    @Autowired
    FileSystemService fileSystemService;

    /**
     * 上传/更新文件
     *
     * @param multipartFile 文件
     * @param filetag       文件标签
     * @param businesskey   业务key
     * @param metadata      元信息,json格式
     * @return
     */
    @Override
    @PostMapping("/upload")
    public UploadFileResult upload(@RequestParam(value = "file", required = true) MultipartFile multipartFile,
                                   @RequestParam(required = true) String filetag,
                                   @RequestParam(required = false) String businesskey,
                                   @RequestParam(required = false) String metadata) {
        System.out.println("服务器上传文件ing ......");
        return fileSystemService.upload(multipartFile, filetag, businesskey, metadata);
    }
}
