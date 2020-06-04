package com.xuecheng.framework.domain.course.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.api.ResultCode;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class AddCourseResult extends ResponseResult {
    public AddCourseResult(ResultCode resultCode,String courseid) {
        super(resultCode);
        this.courseid = courseid;
    }
    private String courseid;

}
