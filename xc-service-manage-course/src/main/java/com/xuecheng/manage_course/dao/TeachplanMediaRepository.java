package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.TeachplanMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeachplanMediaRepository extends JpaRepository<TeachplanMedia, String> {
    /**
     * 根据课程id查询列表
     *
     * @param courseId 课程id
     * @return
     */
    List<TeachplanMedia> findByCourseId(String courseId);
}
