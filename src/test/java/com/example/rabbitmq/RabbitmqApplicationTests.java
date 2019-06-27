package com.example.rabbitmq;

import com.example.rabbitmq.sender.FanoutSender;
import com.example.rabbitmq.sender.Sender;
import com.example.rabbitmq.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {
	@Autowired
	private Sender sender;
	@Autowired
	private FanoutSender fanoutSender;
	@Autowired
	private TopicSender topicSender;


	/**
	 * =======================================订阅者模式 | 路由模式 |3种交换机================================
	 */


	/**
	 * 测试： 生产者发送1条消息----交换器--（路由键）--队列----消费之收到1条消息
	 *
	 * 声明交换机为direct，根据绑定的路由key，消息带哪个key，就路由到哪个队列。可以一个队列绑定多个key
	 */
	@Test
	public void testDirect() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		sender.driectSend("Driect Data：" + sf.format(new Date()));
	}

	/**
	 * 测试： 生产者发送两条消息----交换器---队列1和2----消费之1（监听队列1）和2（监听队列2）分别都收到两条消息
	 *
	 * 测试可以看出fanout会把消息分发到所有订阅到该交换器的队列，fanout模式是忽略路由键的
	 * （不处理路由键），队列绑定到交换机，直接转发到所有队列。
	 * @throws InterruptedException
	 */
	@Test
	public void testFanout() throws InterruptedException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		fanoutSender.send("Time1 => " + sf.format(new Date()));
		fanoutSender.send2("Date2 => " + sf.format(new Date()));
	}

	/**
	 * 测试：在Topic Exchange中“#”可以匹配所有内容，而“*”则是匹配一个字符段的内容。
	 * 只要匹配到的路由键，都会将消息放在该路由键绑定的队列中，监听的消费者就会消费
	 *
	 * 声明交换机为topic 可以实现模式匹配
	 * #匹配一个或多个 *匹配一个
	 * @throws InterruptedException
	 */
	@Test
	public void testTopic() throws InterruptedException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		topicSender.topicSender("topic => " + sf.format(new Date()));
	}

}
