package com.xuecheng.test.rabbitmq.mq;

import com.rabbitmq.client.Channel;
import com.xuecheng.test.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 测试监听
 *
 * @author yuanYuan
 * @version 1.0
 * @date 2020/4/18
 */
@Component
public class ReceiveHandler {
    //@RabbitListener:监听某一个队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void send_email(String msg, Message message, Channel channel) {
        System.out.println("receive message is:" + msg);
    }

}
