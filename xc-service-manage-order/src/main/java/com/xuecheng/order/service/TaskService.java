package com.xuecheng.order.service;

import com.xuecheng.framework.domain.task.XcTask;
import com.xuecheng.framework.domain.task.XcTaskHis;
import com.xuecheng.order.dao.XcTaskHisRepository;
import com.xuecheng.order.dao.XcTaskRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class TaskService {

    @Autowired
    XcTaskRepository xcTaskRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    XcTaskHisRepository xcTaskHisRepository;

    /**
     * 查询前n条任务
     *
     * @param updateTime 时间
     * @param size       大小
     * @return
     */
    public List<XcTask> findXcTaskList(Date updateTime, int size) {
        //设置分页参数
        Pageable pageable = new PageRequest(0, size);
        //查询前n条任务
        Page<XcTask> all = xcTaskRepository.findByUpdateTimeBefore(pageable, updateTime);
        List<XcTask> list = all.getContent();
        return list;
    }

    /**
     * 发布消息
     *
     * @param xcTask
     * @param ex
     * @param routingKey
     */
    public void publish(XcTask xcTask, String ex, String routingKey) {
        Optional<XcTask> optional = xcTaskRepository.findById(xcTask.getId());
        if (optional.isPresent()) {
            //发送消息
            rabbitTemplate.convertAndSend(ex, routingKey, xcTask);
            //更新任务时间
            XcTask one = optional.get();
            one.setUpdateTime(new Date());
            xcTaskRepository.save(one);
        }
    }

    /**
     * 获取任务版本号
     *
     * @param id      任务id
     * @param version 版本锁
     * @return
     */
    @Transactional
    public int getTask(String id, int version) {
        //通过乐观锁的方式来更新数据表，如果结果大于0说明取到任务
        int count = xcTaskRepository.updateTaskVersion(id, version);
        return count;
    }

    /**
     * 完成任务
     *
     * @param taskId 任务Id
     */
    @Transactional
    public void finishTask(String taskId) {
        Optional<XcTask> optionalXcTask = xcTaskRepository.findById(taskId);
        if (optionalXcTask.isPresent()) {
            //当前任务
            XcTask xcTask = optionalXcTask.get();
            //历史任务
            XcTaskHis xcTaskHis = new XcTaskHis();
            BeanUtils.copyProperties(xcTask, xcTaskHis);
            xcTaskHisRepository.save(xcTaskHis);
            xcTaskRepository.delete(xcTask);
        }
    }
}
