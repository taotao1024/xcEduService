package com.xuecheng.api.search;

import com.xuecheng.framework.domain.course.CoursePub;
import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import com.xuecheng.framework.domain.search.CourseSearchParam;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

@Api(value = "课程搜索服务", description = "搜索服务接口", tags = {"搜索服务接口"})
public interface EsCourseControllerApi {
    /**
     * 搜索课程信息
     *
     * @param page              请求第几页内容
     * @param size              每页显示内容个数
     * @param courseSearchParam 综合查询条件
     * @return
     */
    @ApiOperation("查询分页结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "请求第几页内容", dataType = "int", type = "int", paramType = "path"),
            @ApiImplicitParam(name = "size", value = "每页显示内容个数", dataType = "int", type = "int", paramType = "path"),
            @ApiImplicitParam(name = "courseSearchParam", value = "综合查询条件", paramType = "query")
    })
    public QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam);

    @ApiOperation("根据id查询课程信息")
    public Map<String, CoursePub> getAll(String id);

    @ApiOperation("根据课程计划查询媒资信息")
    public TeachplanMediaPub getmedia(String teachplanId);
}
