package com.xuecheng.manage_course.dao;

import com.github.pagehelper.Page;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 课程接口
 */
@Mapper
@Repository
public interface CourseMapper {

    CourseBase findCourseBaseById(String id);

    /**
     * 测试使用
     *
     * @return
     */
    Page<CourseBase> findCourseList();

    /**
     * 分页查询课我的程列表
     *
     * @param courseListRequest
     * @return
     */
    Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
}
