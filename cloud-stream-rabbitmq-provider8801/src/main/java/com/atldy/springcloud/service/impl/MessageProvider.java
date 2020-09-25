package com.atldy.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atldy.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author 唐多山
 * @create 2020-09-22 19:26
 */
@Service
@EnableBinding(Source.class) //定义消息推送管道
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output;


    @Override
    public String send() {
        String uuid = IdUtil.fastSimpleUUID();
        System.out.println("流水号是uuid："+uuid);
        output.send(MessageBuilder.withPayload(uuid).build());
        return null;
    }
}
