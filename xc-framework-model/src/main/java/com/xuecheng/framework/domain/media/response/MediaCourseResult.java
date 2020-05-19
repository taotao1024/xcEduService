package com.xuecheng.framework.domain.media.response;

import com.xuecheng.framework.domain.media.MediaFile;
import com.xuecheng.framework.domain.media.MediaVideoCourse;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.api.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
public class MediaCourseResult extends ResponseResult {
    public MediaCourseResult(ResultCode resultCode, MediaVideoCourse mediaVideoCourse) {
        super(resultCode);
        this.mediaVideoCourse = mediaVideoCourse;
    }

    MediaFile mediaVideo;
    MediaVideoCourse mediaVideoCourse;
}
