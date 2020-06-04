package com.xuecheng.order.dao;

import com.xuecheng.framework.domain.task.XcTaskHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

/**
 * Xc_Task_His表
 */

@Repository
public interface XcTaskHisRepository extends JpaRepository<XcTaskHis, String> {
}
