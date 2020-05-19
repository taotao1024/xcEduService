package com.xuecheng.framework.domain.media.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.api.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
public class CheckChunkResult extends ResponseResult{

    public CheckChunkResult(ResultCode resultCode, boolean fileExist) {
        super(resultCode);
        this.fileExist = fileExist;
    }
    @ApiModelProperty(value = "文件分块存在标记", example = "true", required = true)
    boolean fileExist;
}
