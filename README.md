# rabbitmq
springboot 集成rabbitmq


=====>SpringBoot 整合rabbitMq
https://www.cnblogs.com/vipstone/p/9950434.html   ---docker安装（路由模式）
https://blog.csdn.net/cairuojin/article/details/81912033 ---windows
1.简单队列（此时为匿名发送，不指定交换机，则直接发送到队列中）

2.工作队列WorkQueue  模型（消息轮流被多个消费者消费） 

3.订阅者模式 
（一个生产者，多个消费者，消费者都有自己的队列，消息先发送到交换机exchange，每个队列都绑定到交换机。实现一个消息被多个消费者消费。 ）
队列如果不绑定到交换机，消息丢失，交换机没有存储能力。 
交换机：一方面是接收生产者的消息，另一方面是向队列推送消息。生产者在发布的时候不指定交换机，则为匿名发送。交换机类型如下 
Fanout（不处理路由键），队列绑定到交换机，直接转发到所有队列。 
Direct（处理路由键） ：声明交换机为direct，根据绑定的路由key，消息带哪个key，就路由到哪个队列。可以一个队列绑定多个key
Topic（）声明交换机为topic 可以实现模式匹配 #匹配一个或多个 *匹配一个
![image](https://images.gitbook.cn/05c27fa0-b1e5-11e8-a732-016f6432627f)
![image](https://images.gitbook.cn/6dc16c60-b1e5-11e8-aaa3-f7a30ea6c343)

4、路由模式（上述）
