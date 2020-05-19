package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.*;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.CourseView;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.course.response.AddCourseResult;
import com.xuecheng.framework.domain.course.response.CoursePublishResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value = "课程管理接口", description = "课程管理接口:提供课程管理、查询接口")
public interface CourseControllerApi {
    @ApiOperation(value = "添加课程")
    @ApiImplicitParam(name = "teachplan", value = "授课老师", required = true, paramType = "path", dataType = "Teachplan")
    public ResponseResult addTeachPlan(Teachplan teachplan);

    @ApiOperation(value = "课程计划查询")
    @ApiImplicitParam(name = "courseId", value = "课程id", required = true, paramType = "path", dataType = "string")
    public TeachplanNode findTeachplanList(String courseId);

    @ApiOperation(value = "查询我的课程列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "查询的页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "courseListRequest", value = "课程列表结果", required = true, paramType = "path", dataType = "CourseListRequest")
    })
    public QueryResponseResult<CourseInfo> findCourseList(int page, int size, CourseListRequest courseListRequest);

    @ApiOperation("添加课程基础信息")
    public AddCourseResult addCourseBase(CourseBase courseBase);

    @ApiOperation("获取课程基础信息")
    public CourseBase getCourseBaseById(String courseId) throws RuntimeException;

    @ApiOperation("更新课程基础信息")
    public ResponseResult updateCourseBase(String id, CourseBase courseBase);

    @ApiOperation("获取课程营销信息")
    public CourseMarket getCourseMarketById(String courseId);

    @ApiOperation("更新课程营销信息")
    public ResponseResult updateCourseMarket(String id, CourseMarket courseMarket);

    @ApiOperation("添加课程图片")
    public ResponseResult addCoursePic(String courseId, String pic);

    @ApiOperation("获取课程基础信息")
    public CoursePic findCoursePic(String courseId);

    @ApiOperation("删除课程图片")
    public ResponseResult deleteCoursePic(String courseId);

    @ApiOperation("课程视图查询")
    public CourseView courseview(String id);

    @ApiOperation("预览课程")
    public CoursePublishResult preview(String id);

    @ApiOperation("发布课程")
    public CoursePublishResult publish(@PathVariable String id);

    @ApiOperation("保存媒资信息")
    public ResponseResult saveMedia(TeachplanMedia teachplanMedia);
}
