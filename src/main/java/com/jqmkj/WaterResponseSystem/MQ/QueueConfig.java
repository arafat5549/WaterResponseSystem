package com.jqmkj.WaterResponseSystem.MQ;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class QueueConfig {

    @Bean(name = "realTimeDataQueue")
    public Queue getRealTimeDataQueue() {
        return new ActiveMQQueue("realTimeDataQueue");
    }

    @Bean(name = "minuteDataQueue")
    public Queue getMinuteDataQueue() {
        return new ActiveMQQueue("minuteDataQueue");
    }

    @Bean(name = "hourDataQueue")
    public Queue getHourDataQueue() {
        return new ActiveMQQueue("hourDataQueue");
    }

    @Bean(name = "dayDataQueue")
    public Queue getDayDataQueue() {
        return new ActiveMQQueue("dayDataQueue");
    }
}