package com.example.demo.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Auther: lsm
 * @Date: 2019/6/25 14:19
 * @Description:消息提供者2
 */
@Component
public class Consumer1 {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue", containerFactory = "queueListenerFactory")
    @SendTo("out.queue")
    public String receiveQueue(String text) {

        System.out.println("Consumer1 收到的报文为:"+text);

        return "return message" + text;
    }

    @JmsListener(destination = "out.queue", containerFactory = "queueListenerFactory")
    public void outQueue(String text){
        System.out.println("Consumer1 outQueue:"+text);
    }

    @JmsListener(destination = "mytest.topic", containerFactory = "topicListenerFactory")
    public void topicQueue(String text){
        System.out.println("Consumer1 接收到的 topic 消息：" + text);
    }
}
