package com.jqmkj.WaterResponseSystem.MQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class Consumer {

    @JmsListener(destination = "realTimeDataQueue")
    public void receiveQueue(Map<String,Object> consumer) {
        System.out.println("消息已经消费了realTimeDataQueue");
    }

    @JmsListener(destination = "minuteDataQueue")
    public void receiveQueue2(String consumer) {
        System.out.println(consumer+"消息已经消费了minuteDataQueue");
    }
}
