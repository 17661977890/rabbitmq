
package com.example.rabbitmq.sender;

import com.example.rabbitmq.exchangeconfig.TopicConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void topicSender(String message) {
        String routingKey = "log.all.error";
        System.out.println(routingKey + " 发送消息：" + message);
       // 参数一：交换器名称，；参数二：路由键名称；参数三：存储消息
        this.rabbitTemplate.convertAndSend(TopicConfig.EXCHANGE_NAME, routingKey, message);
    }
}