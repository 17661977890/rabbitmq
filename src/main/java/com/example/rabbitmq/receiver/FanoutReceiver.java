package com.example.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * fanout类型交换器的消费者1
 * 监听队列1--fanout
 */
@Component
@RabbitListener(queues = "fanout")
public class FanoutReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Fanout（FanoutReceiver）消费消息：" + msg);
    }
}