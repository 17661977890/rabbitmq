package com.example.rabbitmq.exchangeconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列交换机的配置 （direct类型：默认类型）
 * RabbitMQ的Exchange（交换器）分为四类：
 * direct（默认）headers fanout topic
 *
 * 声明交换机为direct，根据绑定的路由key，消息带哪个key，就路由到哪个队列。可以一个队列绑定多个key
 *
 * 测试某一项的时候，要将其余的Configuration配置注释掉，要不然会违背bean单例模式
 */
//@Configuration
public class DirectConfig {
    final static String QUEUE_NAME = "direct"; //队列名称
    final static String EXCHANGE_NAME = "mydirect"; //交换器名称
    @Bean
    public Queue queue() {
        // 声明队列 参数一：队列名称；参数二：是否持久化
        return new Queue(DirectConfig.QUEUE_NAME, false);
    }
    // 配置默认的交换机，以下部分都可以不配置，不设置使用默认交换器（AMQP default）
    @Bean
    DirectExchange directExchange() {
        // 参数一：交换器名称；参数二：是否持久化；参数三：是否自动删除消息
        return new DirectExchange(DirectConfig.EXCHANGE_NAME, false, false);
    }
    // 绑定“direct”队列到上面配置的“mydirect”路由器
    @Bean
    Binding bindingExchangeDirectQueue(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(DirectConfig.QUEUE_NAME);
    }
}