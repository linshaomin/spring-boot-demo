package com.example.demo.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: lsm
 * @Date: 2019/6/25 14:19
 * @Description:消息提供者
 */
@Component
public class Consumer {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
    }

    @JmsListener(destination = "mytest.topic", containerFactory = "topicListenerFactory")
    public void topicQueue(String text){
        System.out.println("Consumer 接收到的 topic 消息：" + text);
    }
}
