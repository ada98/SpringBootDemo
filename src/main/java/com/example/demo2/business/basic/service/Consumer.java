package com.example.demo2.business.basic.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @Description:
 * @Author: ada
 * @Date: 2020/4/24 20:46
 * @Vervion: 1.0
 */
@Component
public class Consumer {
    @JmsListener(destination = "web-queue", containerFactory="queueListener")
    public void receiveMsg(Message message) throws JMSException {
        TextMessage textMessage= (TextMessage) message;
        System.out.println("<<<<<<============ 收到消息： " + textMessage.getText());
    }
}
