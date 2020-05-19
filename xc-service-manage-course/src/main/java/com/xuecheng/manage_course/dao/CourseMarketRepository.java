package com.xuecheng.manage_course.dao;


import com.xuecheng.framework.domain.course.CourseMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 课程营销
 */
@Repository
public interface CourseMarketRepository extends JpaRepository<CourseMarket, String> {
}