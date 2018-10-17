package com.jqmkj.WaterResponseSystem.MQ;

import com.jqmkj.WaterResponseSystem.entity.DeviceInfoRealTimeData;
import com.jqmkj.WaterResponseSystem.entity.DeviceinfoDayData;
import com.jqmkj.WaterResponseSystem.entity.DeviceinfoHourData;
import com.jqmkj.WaterResponseSystem.entity.DeviceinfoMinuteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.Map;

@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue realTimeDataQueue;
    @Autowired
    private Queue minuteDataQueue;
    @Autowired
    private Queue hourDataQueue;
    @Autowired
    private Queue dayDataQueue;

    //@Scheduled(fixedDelay = 2000)    // 每2s执行1次
    public void send(DeviceInfoRealTimeData data) {
        jmsMessagingTemplate.convertAndSend(realTimeDataQueue, data);
    }

    //@Scheduled(fixedDelay = 2000)    // 每2s执行1次
    public void send(DeviceinfoMinuteData data) {
        jmsMessagingTemplate.convertAndSend(minuteDataQueue, data);
    }

    public void send(DeviceinfoHourData data) {
        jmsMessagingTemplate.convertAndSend(hourDataQueue, data);
    }

    public void send(DeviceinfoDayData data) {
        jmsMessagingTemplate.convertAndSend(dayDataQueue, data);
    }

}
