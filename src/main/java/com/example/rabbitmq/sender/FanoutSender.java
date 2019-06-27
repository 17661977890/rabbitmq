package com.example.rabbitmq.sender;

import com.example.rabbitmq.exchangeconfig.FanoutConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试可以看出fanout会把消息分发到所有订阅到该交换器的队列，fanout模式是忽略路由键的
 * 两个队列都绑定了交换器
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        System.out.println("发送消息：" + message);
        this.rabbitTemplate.convertAndSend(FanoutConfig.EXCHANGE_NAME,FanoutConfig.QUEUE_NAME, message);
    }
    public void send2(String message) {
        System.out.println("发送消息2：" + message);
        this.rabbitTemplate.convertAndSend(FanoutConfig.EXCHANGE_NAME,FanoutConfig.QUEUE_NAME2, message);
    }
}