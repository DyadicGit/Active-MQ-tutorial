package com.dyadic.playground.activemq.demo.explicitlyDeclared;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

@RestController
@RequestMapping("/send")
public class Producer {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer messageProducer;

    private final String sampleQueue = "sample.queue";

    @GetMapping("/explicit/{message}")
    public String publish(@PathVariable("message") final String messsage) {
        sendMessage(messsage);
        return "Success";
    }

    private void sendMessage(String message) {
        try {
            factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(sampleQueue);
            messageProducer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);

            messageProducer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}