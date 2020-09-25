package com.atldy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 唐多山
 * @create 2020-09-22 21:06
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListennerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        String payload = message.getPayload();
        System.out.println("消费者2号--------->接收到消息"+"\t   port："+serverPort);
    }

}
