package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 课程类别
 */
@Mapper
@Repository
public interface CategoryMapper {
    //查询分类
    public CategoryNode selectList();
}
