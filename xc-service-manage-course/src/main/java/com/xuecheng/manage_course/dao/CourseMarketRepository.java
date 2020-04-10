package com.xuecheng.manage_course.dao;


import com.xuecheng.framework.domain.course.CourseMarket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 课程营销
 */
public interface CourseMarketRepository extends JpaRepository<CourseMarket, String> {
}