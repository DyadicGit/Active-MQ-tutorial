package com.dyadic.playground.activemq.demo.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
public class ActiveMqConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerURL;

    @Value("${app.settings.activemq.sampleQ}")
    private String sampleQueue;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(sampleQueue);
    }

    @Bean
    @Autowired
    public JmsTemplate jmstemplate(ActiveMQConnectionFactory activeMQConnectionFactory) {
        return new JmsTemplate(activeMQConnectionFactory);
    }
}
