package com.example.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * fanout类型交换器的消费者2
 * 监听队列2--fanout2
 */
@Component
@RabbitListener(queues = "fanout2")
public class FanoutReceiver2 {
    @RabbitHandler
    public void process(String message) {
        System.out.println("Fanout（FanoutReceiver2）消费消息：" + message);
    }
}