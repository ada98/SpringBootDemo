package com.example.demo2.business.basic.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @Description: ActiveMQ生产者
 * @Author: ada
 * @Date: 2020/4/24 20:48
 * @Vervion: 1.0
 */
@Service
public class Producer {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String destinationName, String message) {
        System.out.println("============>>>>> 发送queue消息 " + message);
        Destination destination = new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
