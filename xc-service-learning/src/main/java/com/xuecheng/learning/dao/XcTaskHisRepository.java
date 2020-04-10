package com.xuecheng.learning.dao;

import com.xuecheng.framework.domain.task.XcTaskHis;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 历史任务Dao
 */
public interface XcTaskHisRepository extends JpaRepository<XcTaskHis, String> {
}