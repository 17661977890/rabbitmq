package com.example.rabbitmq.receiver;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息接收者-消费消息
 * @RabbitListener(queues = "direct") 指定监听那个队列
 */
@Component
@RabbitListener(queues = "direct")
public class Receiver {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 监听消费消息
     */
    @RabbitHandler
    public void process(String message) {
        System.out.println("Direct 消费消息：" + message);
    }
}