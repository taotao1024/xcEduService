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
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/filesystem")
public class FileSystemController implements FileSystemControllerApi {
    @Autowired
    FileSystemService fileSystemService;


    @Override
    @PostMapping("/upload")
    public UploadFileResult upload(@RequestParam(value = "file", required = true) MultipartFile multipartFile,
                                   @RequestParam(required = true) String filetag,
                                   @RequestParam(required = false) String businesskey,
                                   @RequestParam(required = false) String metadata) {
        return fileSystemService.upload(multipartFile, filetag, businesskey, metadata);
    }
}
