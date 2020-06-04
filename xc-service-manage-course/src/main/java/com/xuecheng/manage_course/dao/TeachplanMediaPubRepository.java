package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachplanMediaPubRepository extends JpaRepository<TeachplanMediaPub, String> {
    /**
     * 根据课程id删除课程计划媒资信息
     *
     * @param courseId 课程id
     * @return
     */
    long deleteByCourseId(String courseId);
}
