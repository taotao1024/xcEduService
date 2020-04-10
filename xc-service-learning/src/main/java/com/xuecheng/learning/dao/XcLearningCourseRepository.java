package com.xuecheng.learning.dao;

import com.xuecheng.framework.domain.learning.XcLearningCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 学生选课Dao
 */
public interface XcLearningCourseRepository extends JpaRepository<XcLearningCourse, String> {
    /**
     * 根据用户和课程查询选课记录，用于判断是否添加选课
     *
     * @param userId   用户Id
     * @param courseId 课程Id
     * @return
     */
    XcLearningCourse findXcLearningCourseByUserIdAndCourseId(String userId, String courseId);
}