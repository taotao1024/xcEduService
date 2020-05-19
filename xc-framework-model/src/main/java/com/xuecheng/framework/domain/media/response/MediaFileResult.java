package com.xuecheng.framework.domain.media.response;

import com.xuecheng.framework.domain.media.MediaFile;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.api.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MediaFileResult extends ResponseResult {
    MediaFile mediaFile;
    public MediaFileResult(ResultCode resultCode, MediaFile mediaFile) {
        super(resultCode);
        this.mediaFile = mediaFile;
    }
}
