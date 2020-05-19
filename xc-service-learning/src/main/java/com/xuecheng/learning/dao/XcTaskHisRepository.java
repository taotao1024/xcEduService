package com.xuecheng.learning.dao;

import com.xuecheng.framework.domain.task.XcTaskHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 历史任务Dao
 */
@Repository
public interface XcTaskHisRepository extends JpaRepository<XcTaskHis, String> {
}