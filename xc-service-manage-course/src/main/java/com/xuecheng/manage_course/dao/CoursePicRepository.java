package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CoursePic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePicRepository extends JpaRepository<CoursePic, String> {
    //删除成功返回1否则返回0
    long deleteByCourseid(String courseid);
}