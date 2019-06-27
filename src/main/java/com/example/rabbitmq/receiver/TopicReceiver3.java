package com.example.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * 消费者1，监听队列log.all.error，该队列绑定路由键log.*.error
 */
@Component
@RabbitListener(queues = "log.all.error")
public class TopicReceiver3 {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("log.*.error 消费消息：" + msg);
    }
}