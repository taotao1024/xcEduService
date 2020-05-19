package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CoursePub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePubRepository extends JpaRepository<CoursePub, String> {
}
