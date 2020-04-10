package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "课程分类管理", description = "课程分类管理接口:提供课程管理、查询接口")
public interface CategoryControllerApi {

    @ApiOperation(value = "查询分类")
    public CategoryNode findList();

}
