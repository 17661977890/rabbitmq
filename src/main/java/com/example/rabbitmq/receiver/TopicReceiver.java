package com.example.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者1，监听队列log，该队列绑定路由键log.#
 */
@Component
@RabbitListener(queues = "log")
public class TopicReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("log.# 消费消息：" + msg);
    }
}