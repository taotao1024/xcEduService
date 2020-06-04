package com.xuecheng.manage_media.service;

import com.xuecheng.framework.domain.media.MediaFile;
import com.xuecheng.framework.domain.media.request.QueryMediaFileRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.bean.QueryResult;
import com.xuecheng.manage_media.dao.MediaFileRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaFileService {

    @Autowired
    MediaFileRepository mediaFileRepository;

    /**
     * 查询媒资列表
     *
     * @param page
     * @param size
     * @param queryMediaFileRequest
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest) {
        //参数处理
        if (0 >= page) {
            page = 1;
        }
        page = page - 1;
        if (0 >= size) {
            size = 10;
        }
        if (null == queryMediaFileRequest) {
            queryMediaFileRequest = new QueryMediaFileRequest();
        }
        //条件值对象
        MediaFile mediaFile = new MediaFile();
        if (StringUtils.isNotEmpty(queryMediaFileRequest.getTag())) {
            mediaFile.setTag(queryMediaFileRequest.getTag());
        }
        if (StringUtils.isNotEmpty(queryMediaFileRequest.getFileOriginalName())) {
            mediaFile.setFileOriginalName(queryMediaFileRequest.getFileOriginalName());
        }
        if (StringUtils.isNotEmpty(queryMediaFileRequest.getProcessStatus())) {
            mediaFile.setProcessStatus(queryMediaFileRequest.getProcessStatus());
        }
        //条件匹配器
        ExampleMatcher matching = ExampleMatcher.matching()
                //标签模糊匹配
                .withMatcher("tag", ExampleMatcher.GenericPropertyMatchers.contains())
                //文件原始名称模糊匹配
                .withMatcher("fileOriginalName", ExampleMatcher.GenericPropertyMatchers.contains())
                //处理状态精确匹配（默认）
                .withMatcher("processStatus", ExampleMatcher.GenericPropertyMatchers.exact());
        //example对象
        Example<MediaFile> example = Example.of(mediaFile, matching);
        //分页
        Pageable pageable = new PageRequest(page, size);
        Page<MediaFile> all = mediaFileRepository.findAll(example, pageable);
        //总记录数
        long totalElements = all.getTotalElements();
        //记录列表
        List<MediaFile> content = all.getContent();
        //返回
        QueryResult queryResult = new QueryResult();
        queryResult.setTotal(totalElements);
        queryResult.setList(content);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }
}
